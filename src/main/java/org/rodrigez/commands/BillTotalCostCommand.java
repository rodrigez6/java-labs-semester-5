package org.rodrigez.commands;

import org.rodrigez.model.Designer;
import org.rodrigez.model.Specification;
import org.rodrigez.routing.Request;
import org.rodrigez.routing.RequestException;
import org.rodrigez.service.DesignerService;

public class BillTotalCostCommand extends Command {
    @Override
    public String execute(Request request) throws RequestException {
        try {
            Designer designer = (Designer) request.getAttribute("designer");
            Specification specification = (Specification) request.getAttribute("specification");
            DesignerService designerService = new DesignerService();
            designerService.bill(designer,specification);
            double cost = specification.getCost();
            String oldmsg = (String) request.getAttribute("message");
            String msg = designer.getName() + " bill total cost of project design and construction: " + cost;
            request.setAttribute("message", oldmsg + "\n" + msg);
        } catch (RequestException e) {
            request.setAttribute("message",e.toString());
            return "error";
        }
        return executeNext(request);
    }
}
