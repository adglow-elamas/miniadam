package domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="ADSETS")
public class AdSet {

	@Id
	@Column(name = "ADS_ID")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

	@Column(name = "ADS_NAME")
	private String name;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CAM_ID")
	private Campaign campaign;	
	
	@OneToMany(
	        mappedBy = "adSet", 
	        cascade = CascadeType.ALL, 
	        orphanRemoval = false
	    )
	private List<Ad> ads = new ArrayList<Ad>();
	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Campaign getCampaign() {
		return campaign;
	}

	public void setCampaign(Campaign campaign) {
		this.campaign = campaign;
	}
	
    public void addAd(Ad ad) {
        ads.add(ad);
        ad.setAdSet(this);
    }
 
    public void removeAd(Ad ad) {
    	ads.remove(ad);
    	ad.setAdSet(null);
    }	
	
	/*
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AdSet )) return false;
        return id != null && id.equals(((AdSet) o).id);
    }
    
    @Override
    //TODO no se que tengo que poner ahi
    public int hashCode() {
        return 31;
    }
    */
}