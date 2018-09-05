package brokers.entity;

import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection = "domain")
public class Domain {

 @org.springframework.data.annotation.Id
    private Long Id;

    @Indexed(unique = true)
    private String domain;

    private boolean displayAds;


    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    public boolean isDisplayAds() {
        return displayAds;
    }

    public void setDisplayAds(boolean displayAds) {
        this.displayAds = displayAds;
    }
}
