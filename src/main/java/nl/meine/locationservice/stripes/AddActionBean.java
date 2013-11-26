/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package nl.meine.locationservice.stripes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sql.DataSource;
import net.sourceforge.stripes.action.ActionBean;
import net.sourceforge.stripes.action.ActionBeanContext;
import net.sourceforge.stripes.action.DefaultHandler;
import net.sourceforge.stripes.action.ForwardResolution;
import net.sourceforge.stripes.action.Resolution;
import net.sourceforge.stripes.action.StrictBinding;
import net.sourceforge.stripes.action.UrlBinding;
import net.sourceforge.stripes.validation.Validate;
import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;

/**
 *
 * @author Meine Toonen <toonen.meine@gmail.com>
 */
@UrlBinding("/add/{key}/{x},{y}")
@StrictBinding
public class AddActionBean implements ActionBean {

    private ActionBeanContext context;
    private static final String JSP = "/WEB-INF/jsp/view.jsp";
    @Validate
    private String key;
    @Validate
    private Integer x;
    @Validate
    private Integer y;

    // <editor-fold desc="Getters and Setters" defaultstate="collapsed" >
    @Override
    public void setContext(ActionBeanContext abc) {
        this.context = abc;
    }

    @Override
    public ActionBeanContext getContext() {
        return this.context;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
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
    // </editor-fold>

    @DefaultHandler
    public Resolution view() {
        save();
        return new ForwardResolution(JSP);
    }

    private void save() {
        Connection conn= null;
        try {
            conn = getConnection();

    // No DataSource so we must handle Connections manually
            QueryRunner run = new QueryRunner();
            run.update(conn,"INSERT INTO location (key,x,y) VALUES (?,?,?)",key,x,y);
            int a = 0;
        } catch (SQLException ex) {
            Logger.getLogger(AddActionBean.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            DbUtils.closeQuietly(conn);
            
        }
    }

    private Connection getConnection() throws SQLException {
        Properties props = new Properties();
        props.put("user", "locationservice");
        props.put("password", "locationservice  ");
        return DriverManager.getConnection("jdbc:postgresql://localhost/locationservice", props);
    }
}
