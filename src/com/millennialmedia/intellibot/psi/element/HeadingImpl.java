package com.millennialmedia.intellibot.psi.element;

import com.intellij.lang.ASTNode;
import com.millennialmedia.intellibot.psi.RobotTokenTypes;
import org.jetbrains.annotations.NotNull;

/**
 * @author Stephen Abrams
 */
public class HeadingImpl extends RobotPsiElementBase implements Heading {

    public HeadingImpl(@NotNull final ASTNode node) {
        super(node, RobotTokenTypes.HEADING);
    }

    @Override
    public boolean isSettings() {
        String text = getTextData();
        return text != null && text.startsWith("*** Setting");
    }

    @Override
    public boolean containsKeywordDefinitions() {
        String text = getTextData();
        return text != null && (text.startsWith("*** Keyword") || text.startsWith("*** User Keyword"));
    }

    @Override
    public boolean containsImports() {
        return isSettings();
    }
}