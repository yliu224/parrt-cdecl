package cs652.cdecl;

import g4.CDeclBaseVisitor;
import g4.CDeclParser;

public class EnglishGenerator extends CDeclBaseVisitor<String> {
    @Override
    public String visitDeclaration(CDeclParser.DeclarationContext ctx) {
        //return super.visitDeclaration(ctx);
        return visit(ctx.getChild(1))+visit(ctx.getChild(0));
    }

    @Override
    public String visitTypename(CDeclParser.TypenameContext ctx) {
        //return super.visitTypename(ctx);
        if(ctx.getChild(0).getText().equals("void")){
            return "nothing";
        }
        else{
            return ctx.getChild(0).getText();
        }
    }

    @Override
    public String visitArray(CDeclParser.ArrayContext ctx) {
        //return super.visitArray(ctx);
        //List<ParseTree> l= ctx.children;
        return visit(ctx.getChild(0))+"array of ";
    }

    @Override
    public String visitFunc(CDeclParser.FuncContext ctx) {
        //return super.visitFunc(ctx);
        return visit(ctx.getChild(0))+"function returning ";
    }

    @Override
    public String visitVar(CDeclParser.VarContext ctx) {
        //return super.visitVar(ctx);
        return ctx.getChild(0).getText()+" is a ";
    }

    @Override
    public String visitPointer(CDeclParser.PointerContext ctx) {
        //return super.visitPointer(ctx);
        return visit(ctx.getChild(1))+"pointer to ";
    }

    @Override
    public String visitGrouping(CDeclParser.GroupingContext ctx) {
        //return super.visitGrouping(ctx);
        return visit(ctx.getChild(1));
    }
}
