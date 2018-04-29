package llvm;

import java.util.List;
import arm.*;

public interface LLVM {

    public void printOut();
    public void printOutARM();

    public String getResultReg();
    public String getResultType();

    public void addARM( ARM arm );
    public void addARMList(List<ARM> arms );
}
