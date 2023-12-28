package repositories;

import common.Predicates;

public class CompilePredicate extends PredicateSyntaxBaseVisitor<Predicate>{

    @Override
    public Predicate visitPredicate(PredicateSyntax.PredicateContext ctx) {
        Predicate p = visitExpression(ctx.expression());
        return p;
    }

    @Override
    public Predicate visitExpression(PredicateSyntax.ExpressionContext ctx) {
        Predicate p = null;
        switch (ctx.getChildCount()){
            case 1: p=visitPrimitive_predicate(ctx.primitive_predicate());
                break;
            case 2: Predicate p0 = visitExpression(ctx.expression(0));
                p = new Predicate(ctx.getText(), p0.getPredicate().negate());
                break;
            case 3:
                Predicate p1 = visitExpression(ctx.expression(0));
                Predicate p2 = visitExpression(ctx.expression(1));
                if (ctx.getChild(1).getText().equals("and"))
                    p = new Predicate(ctx.getText(), p1.getPredicate().and(p2.getPredicate()));
                else
                    if (ctx.getChild(1).getText().equals("or"))
                       p = new Predicate(ctx.getText(), p1.getPredicate().or(p2.getPredicate()));
                    else
                       p = p1;
                break;
        }
        return p;
    }

    @Override
    public Predicate visitPrimitive_predicate(PredicateSyntax.Primitive_predicateContext ctx) {
        Predicate p = null;

        switch(ctx.getChild(0).getText()){
            case "true":
                p = new Predicate(ctx.getText(),Predicates.noRestriction());
                break;
            case "numberInformationSpaceStrongSets":
                Integer left,right;
                left = Integer.valueOf(ctx.INT(0).getText());
                right = Integer.valueOf(ctx.INT(1).getText());
                p = new Predicate(ctx.getText(),
                        Predicates.numberInformationSpaceStrongSets(left,right));
                break;
            case "numberInformationSpaceWeakSets":
                left = Integer.valueOf(ctx.INT(0).getText());
                right = Integer.valueOf(ctx.INT(1).getText());
                p = new Predicate(ctx.getText(),
                        Predicates.numberInformationSpaceWeakSets(left,right));
                break;
            case "numberStateSpaceStrongSets":
                left = Integer.valueOf(ctx.INT(0).getText());
                right = Integer.valueOf(ctx.INT(1).getText());
                p = new Predicate(ctx.getText(),
                        Predicates.numberStateSpaceStrongSets(left,right));
                break;
            case "numberStateSpaceWeakSets":
                left = Integer.valueOf(ctx.INT(0).getText());
                right = Integer.valueOf(ctx.INT(1).getText());
                p = new Predicate(ctx.getText(),
                        Predicates.numberStateSpaceWeakSets(left,right));
                break;
            case "meanSizeInformationSpaceStrongSets":
                Double threshold = Double.valueOf(ctx.DBL().getText());
                p = new Predicate(ctx.getText(),
                        Predicates.meanSizeInformationSpaceStrongSets(threshold));
                break;
            case "meanSizeInformationSpaceStrongSetsMax":
                threshold = Double.valueOf(ctx.DBL().getText());
                p = new Predicate(ctx.getText(),
                        Predicates.meanSizeInformationSpaceStrongSetsMax(threshold));
                break;
            case "meanSizeInformationSpaceWeakSets":
                threshold = Double.valueOf(ctx.DBL().getText());
                p = new Predicate(ctx.getText(),
                        Predicates.meanSizeInformationSpaceWeakSets(threshold));
                break;
            case "meanSizeInformationSpaceWeakSetsMax":
                threshold = Double.valueOf(ctx.DBL().getText());
                p = new Predicate(ctx.getText(),
                        Predicates.meanSizeInformationSpaceWeakSetsMax(threshold));
                break;
            case "meanSizeStateSpaceStrongSets":
                threshold = Double.valueOf(ctx.DBL().getText());
                p = new Predicate(ctx.getText(),
                        Predicates.meanSizeStateSpaceStrongSets(threshold));
                break;
            case "meanSizeStateSpaceStrongSetsMax":
                threshold = Double.valueOf(ctx.DBL().getText());
                p = new Predicate(ctx.getText(),
                        Predicates.meanSizeStateSpaceStrongSetsMax(threshold));
                break;
            case "meanSizeStateSpaceWeakSets":
                threshold = Double.valueOf(ctx.DBL().getText());
                p = new Predicate(ctx.getText(),
                        Predicates.meanSizeStateSpaceWeakSets(threshold));
                break;
            case "meanSizeStateSpaceWeakSetsMax":
                threshold = Double.valueOf(ctx.DBL().getText());
                p = new Predicate(ctx.getText(),
                        Predicates.meanSizeStateSpaceWeakSetsMax(threshold));
                break;
            case "meanRelativeSizeInformationSpaceStrongSets":
                threshold = Double.valueOf(ctx.DBL().getText());
                p = new Predicate(ctx.getText(),
                        Predicates.meanRelativeSizeInformationSpaceStrongSets(threshold));
                break;
            case "meanRelativeSizeInformationSpaceStrongSetsMax":
                threshold = Double.valueOf(ctx.DBL().getText());
                p = new Predicate(ctx.getText(),
                        Predicates.meanRelativeSizeInformationSpaceStrongSetsMax(threshold));
                break;
            case "meanRelativeSizeInformationSpaceWeakSets":
                threshold = Double.valueOf(ctx.DBL().getText());
                p = new Predicate(ctx.getText(),
                        Predicates.meanRelativeSizeInformationSpaceWeakSets(threshold));
                break;
            case "meanRelativeSizeInformationSpaceWeakSetsMax":
                threshold = Double.valueOf(ctx.DBL().getText());
                p = new Predicate(ctx.getText(),
                        Predicates.meanRelativeSizeInformationSpaceWeakSetsMax(threshold));
                break;
            case "meanRelativeSizeStateSpaceStrongSets":
                threshold = Double.valueOf(ctx.DBL().getText());
                p = new Predicate(ctx.getText(),
                        Predicates.meanRelativeSizeStateSpaceStrongSets(threshold));
                break;
            case "meanRelativeSizeStateSpaceStrongSetsMax":
                threshold = Double.valueOf(ctx.DBL().getText());
                p = new Predicate(ctx.getText(),
                        Predicates.meanRelativeSizeStateSpaceStrongSetsMax(threshold));
                break;
            case "meanRelativeSizeStateSpaceWeakSets":
                threshold = Double.valueOf(ctx.DBL().getText());
                p = new Predicate(ctx.getText(),
                        Predicates.meanRelativeSizeStateSpaceWeakSets(threshold));
                break;
            case "meanRelativeSizeStateSpaceWeakSetsMax":
                threshold = Double.valueOf(ctx.DBL().getText());
                p = new Predicate(ctx.getText(),
                        Predicates.meanRelativeSizeStateSpaceWeakSetsMax(threshold));
                break;
        }
        return p;
    }
}
