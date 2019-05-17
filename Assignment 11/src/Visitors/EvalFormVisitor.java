package Visitors;

import Forms.AtomForm;
import Forms.ConstantForm;
import Forms.NotForm;
import Forms.BinOpForm;
import java.util.Map;

/**
 * A class designed to evaluate given formulas
 * 
 * @author Dennis den Hollander s4776658
 * @author Tom Kamp s4760921
 */
public class EvalFormVisitor implements FormVisitor<Boolean> {
    
    private final Map<String,Boolean> ENVIRONMENT;
    
    public EvalFormVisitor (Map<String,Boolean> environment) {
        this.ENVIRONMENT = environment;
    }

    @Override
    public Boolean visit(NotForm form) {
        return !form.getOperand().accept(this);
    }

    @Override
    public Boolean visit(BinOpForm form) {
        return form.getOperand().apply(
          form.getLeftOperand().accept(this), 
          form.getRightOperand().accept(this)
        );
    }

    @Override
    public Boolean visit(ConstantForm form) {
        return form.getBooleanVal();
    }

    @Override
    public Boolean visit(AtomForm atomForm) {
        return atomForm.getVariableValue(ENVIRONMENT);
    }
}
