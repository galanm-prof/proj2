package common;

import org.antlr.v4.gui.TreeViewer;
import org.antlr.v4.runtime.Parser;
import org.antlr.v4.runtime.tree.ParseTree;

import javax.swing.*;
import java.util.Arrays;

public class ShowParseTree {
    public static <T extends Parser> void show_parse_tree(T anasint, ParseTree tree, String msg){
        JFrame frame = new JFrame("Antlr ParseTree ("+msg+")");
        TreeViewer v = new TreeViewer(Arrays.asList(anasint.getRuleNames()),tree);
        JScrollPane panel = new JScrollPane(v);
        frame.add(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setSize(1000,300);
        frame.setVisible(true);
    }
}
