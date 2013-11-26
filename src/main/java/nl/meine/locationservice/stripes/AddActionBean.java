/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package nl.meine.locationservice.stripes;

import net.sourceforge.stripes.action.ActionBean;
import net.sourceforge.stripes.action.ActionBeanContext;
import net.sourceforge.stripes.action.DefaultHandler;
import net.sourceforge.stripes.action.ForwardResolution;
import net.sourceforge.stripes.action.Resolution;
import net.sourceforge.stripes.action.StrictBinding;
import net.sourceforge.stripes.action.UrlBinding;
import net.sourceforge.stripes.validation.Validate;

/**
 *
 * @author Meine Toonen <toonen.meine@gmail.com>
 */

@UrlBinding("/add/{id}/{x},{y}")
@StrictBinding
public class AddActionBean implements ActionBean{
    private ActionBeanContext context;
    private static final String JSP  = "/WEB-INF/jsp/view.jsp";
    
    @Validate
    private Integer id;
    
    @Validate
    private Integer x;
    
    @Validate
    private Integer y;
    
    @Override
    public void setContext(ActionBeanContext abc) {
        this.context = abc;
    }

    @Override
    public ActionBeanContext getContext() {
        return this.context;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getX() {
        return x;
    }

    public void setX(Integer x) {
        this.x = x;
    }

    public Integer getY() {
        return y;
    }

    public void setY(Integer y) {
        this.y = y;
    }
    
    
    
    @DefaultHandler
    public Resolution view(){
        return new ForwardResolution(JSP);
    }
    
}
