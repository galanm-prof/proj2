package common;

public class ContextualError {
    private Integer line;
    private String msg;

    public ContextualError(Integer line, String msg){
        this.line=line;
        this.msg=msg;
    }

    public String toString(){
        return "Contextual error [linea: "+line+", error: "+msg+"]";
    }

    public Integer getLine() {
        return line;
    }

    public String getMsg() {
        return msg;
    }
}
