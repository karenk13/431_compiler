package ast;

public interface Type
{
    public boolean equals(Type left);
    public String toLLVMType();

}
