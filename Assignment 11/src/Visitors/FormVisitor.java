package Visitors;

import Forms.AtomForm;
import Forms.ConstantForm;
import Forms.NotForm;
import Forms.BinOpForm;

/**
 * @author Dennis den Hollander s4776658
 * @author Tom Kamp s4760921
 * @param <R>
 */
public interface FormVisitor <R> {
    
    R visit (NotForm notForm);
    
    R visit (BinOpForm binOpForm);
    
    R visit (ConstantForm constantForm);
    
    R visit (AtomForm atomForm);
    
}
