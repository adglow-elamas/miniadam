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
@Table(name="ADS")
public class Ad {

	@Id
	@Column(name = "AD_ID")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

	@Column(name = "AD_NAME")
	private String name;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ADS_ID")
	private AdSet adSet;	
	
	@OneToMany(
	        mappedBy = "ad", 
	        cascade = CascadeType.ALL, 
	        orphanRemoval = false
	    )
	private List<Stat> stats = new ArrayList<Stat>();

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

	public AdSet getAdSet() {
		return adSet;
	}

	public void setAdSet(AdSet adSet) {
		this.adSet = adSet;
	}
	
    public void addStat(Stat stat) {
    	stats.add(stat);
    	stat.setAd(this);
    }
 
    public void removeStat(Stat stat) {
    	stats.remove(stat);
    	stat.setAd(null);
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