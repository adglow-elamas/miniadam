package domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="CAMPAIGNS")
public class Campaign {

	@Id
	@Column(name = "CAM_ID")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

	@Column(name = "CAM_NAME")
	private String name;
	
	@OneToMany(
	        mappedBy = "campaign", 
	        cascade = CascadeType.ALL, 
	        orphanRemoval = false
	    )
	private List<AdSet> adSets = new ArrayList<AdSet>();
	
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
	
    public void addAdSet(AdSet adSet) {
        adSets.add(adSet);
        adSet.setCampaign(this);
    }
 
    public void removeAdSet(AdSet adSet) {
    	adSets.remove(adSet);
    	adSet.setCampaign(null);
    }	
}