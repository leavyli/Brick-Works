import org.apache.commons.lang3.SystemUtils;
import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugins.annotations.Mojo;

/**
 * Author saino
 * LastModify 15:51
 */
@Mojo(name = "systeminfo")
public class SystemInfoMojo extends AbstractMojo {
    @Override
    public void execute() throws MojoExecutionException {
        getLog().info("SystemInfoMojo");
        getLog().info( "Java Home: " + SystemUtils.JAVA_HOME );
        getLog().info( "Java Version: "+ SystemUtils.JAVA_VERSION);
        getLog().info( "OS Name: " + SystemUtils.OS_NAME );
        getLog().info( "OS Version: " + SystemUtils.OS_VERSION );
        getLog().info( "User Name: " + SystemUtils.USER_NAME );
    }
}
