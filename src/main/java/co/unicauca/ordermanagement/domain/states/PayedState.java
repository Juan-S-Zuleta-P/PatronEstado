
package co.unicauca.ordermanagement.domain.states;

import co.unicauca.ordermanagement.domain.Order;

/**
 *
 * @author Rivera
 */

/**
 * Clase que determina el estado a pagado
 */
public class PayedState extends OrderState{

    public PayedState(Order order) {
        super(order);
    }
    
    

    @Override
    public String getStateDescription() {
        return "Pagada";
    }
    /**
     * Realiza el envio de la orden si el se ha recibido el pago
     * @param parcelNumber numero de pago
     * @return 
     */
    @Override
    public OrderState orderSendOut(String parcelNumber) {
        if(!getOrder().isPaymentReceived()){
            throw new IllegalStateException("No se puede hacer la orden porque no se recibido el pago");
        }
        return new SendState(getOrder());
    }
    
}
