package test;

import request.SyntaxAnalysisReq;
import specification.SyntaxAnalysis;

public class TestSyntaxAnalysis {
    public static void main(String[] args) throws Exception{
        //Test the syntax analysis of all requests
        SyntaxAnalysisReq.syntaxAnalysisReqs();
        //Test the syntax analysis of all specifications
        //SyntaxAnalysis.syntaxAnalysisSpecs();
    }
}
