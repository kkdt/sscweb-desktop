package kkdt.ssc.desktop;

import org.springframework.boot.Banner;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class SSCDesktopApplication {
    public static void main(String[] args) {
        SpringApplicationBuilder app = new SpringApplicationBuilder(SSCDesktopApplication.class)
            .bannerMode(Banner.Mode.OFF)
            .logStartupInfo(false)
            .headless(false)
            .web(WebApplicationType.NONE);
        app.run(args);
    }
}
