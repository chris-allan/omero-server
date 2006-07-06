package ome.server.itests;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.test.AbstractDependencyInjectionSpringContextTests;
import org.testng.annotations.Configuration;
import org.testng.annotations.Test;

import ome.api.IAdmin;
import ome.api.IAnalysis;
import ome.api.IPixels;
import ome.api.IPojos;
import ome.api.local.LocalQuery;
import ome.api.local.LocalUpdate;
import ome.system.EventContext;
import ome.system.OmeroContext;
import ome.system.Principal;
import ome.system.ServiceFactory;

@Test(
        groups = {"integration"}
)
        
public class AbstractManagedContextTest
        extends AbstractDependencyInjectionSpringContextTests
{
    
    // ~ Testng Adapter
    // =========================================================================
    @Configuration(beforeTestMethod = true)
    public void adaptSetUp() throws Exception{setUp();}
    @Configuration(afterTestMethod = true)
    public void adaptTearDown() throws Exception{tearDown();}
    // =========================================================================
    
    protected LocalQuery iQuery;

    protected LocalUpdate iUpdate;
    
    protected IAdmin iAdmin;
    
    protected IAnalysis iAnalysis;
    
    protected IPojos iPojos;
    
    protected IPixels iPixels;
    
    protected EventContext eContext;
    
    /**
     * @see org.springframework.test.AbstractDependencyInjectionSpringContextTests#onSetUp()
     */
    protected void onSetUp() throws Exception {
    	ServiceFactory factory = new ServiceFactory( (OmeroContext) applicationContext );
        iQuery = (LocalQuery) factory.getQueryService();
        iUpdate = (LocalUpdate) factory.getUpdateService();
        iAdmin = factory.getAdminService();
        iAnalysis = factory.getAnalysisService();
        iPojos = factory.getPojosService();
        iPixels = factory.getPixelsService();
        eContext = (EventContext) applicationContext.getBean("eventContext");
        loginRoot();
    }
    
    protected void loginRoot()
    {
        login("root","system","Test");
    }

    protected void loginUser( String omeName )
    {
        login(omeName,"user","Test");
    }

    
    protected String[] getConfigLocations() { return new String[]{}; }
    protected ConfigurableApplicationContext getContext(Object key)
    {
        return OmeroContext.getManagedServerContext();
    }
    
    protected void login(String userName, String groupName, String eventType)
    {
        eContext.setPrincipal( 
                new Principal( userName, groupName, eventType ));
    }

}
