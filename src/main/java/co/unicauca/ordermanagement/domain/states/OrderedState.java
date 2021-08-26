package co.unicauca.ordermanagement.domain.states;

import co.unicauca.ordermanagement.domain.Order;

/**
 * Estado ordenado
 *
 * @author ahurtado
 */
public class OrderedState extends OrderState {

    /**
     * @param order to be processed
     */
    public OrderedState(Order order) {
        super(order);
    }

    /**
     * @return description
     */
    @Override
    public String getStateDescription() {
        return "Ordenada";
    }

    @Override
    public OrderState cancel() {
        return new CanceledState(getOrder());
    }
   /**
    * Determina si la orden ha sido pagada y envia la orden a estado pagado
    * @param parcelNumber numero de la orden
    * @return orden que se ha realizado
    */
    @Override
    public OrderState orderedPayed (String parcelNumber){
        if(!getOrder().isPaymentReceived()){
            throw new IllegalStateException("An order should not be send out when payment is not received.");
        }
        return new PayedState(getOrder());
    }

}
