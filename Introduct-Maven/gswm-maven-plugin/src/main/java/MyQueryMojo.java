import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;

import java.util.List;

/**
 * Author saino
 * LastModify 19:00
 */
@Mojo(name = "myquery")
public class MyQueryMojo extends AbstractMojo {
    @Parameter(property = "query.url", required = true)
    private String url;
    @Parameter(property = "timeout", required = false, defaultValue = "50")
    private int timeout;

    @Parameter(property = "options", required = false, defaultValue = "50")
    private List<String> options;

    @Override
    public void execute() throws MojoExecutionException {
        getLog().info("MyQueryMojo url:"+ url + " timeout:" + timeout + " options:" + options);
    }
}
