package domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

//@IdClass(StatPK.class)
@Entity
@Table(name="AD_STATS")
public class Stat {
	
//	@Id 
//	@Column(name = "STA_DATE_MILLIS")
//	private Long millis;
	
//	@Id
//	@Column(name = "AD_ID")
//	private Long ad_id;
	
	@EmbeddedId
    private StatPK id;	
	
	@Column(name = "STA_IMPRESSIONS")
	private Long impressions;
	

    @ManyToOne
    @JoinColumn(name = "AD_ID",insertable = false, updatable = false)
    private Ad ad;	

//	public Long getMillis() {
//		return millis;
//	}
//
//	public void setMillis(Long millis) {
//		this.millis = millis;
//	}

	public Long getImpressions() {
		return impressions;
	}

	public void setImpressions(Long impressions) {
		this.impressions = impressions;
	}

//	public Long getAdId() {
//		return ad_id;
//	}
//
//	public void setAdId(Long ad_id) {
//		this.ad_id = ad_id;
//	}
//
	public Ad getAd() {
		return ad;
	}

	public void setAd(Ad ad) {
		this.ad = ad;
	}
	
}

//se necesita por tener una composite key
@Embeddable
class StatPK implements Serializable {
	
	@Column(name = "STA_DATE_MILLIS")
	private Long millis;

	@Column(name = "AD_ID")
	private Long ad_id;

  public Long getMillis() {
		return millis;
	}

	public void setMillis(Long millis) {
		this.millis = millis;
	}

	public Long getAdId() {
		return ad_id;
	}

	public void setAdId(Long ad_id) {
		this.ad_id = ad_id;
	}

	public int hashCode() {
      return millis.hashCode() + ad_id.hashCode();
  }

  public boolean equals(Object obj) {
      if (obj == this) return true;
      if (!(obj instanceof StatPK)) return false;
      if (obj == null) return false;
      StatPK pk = (StatPK) obj;
      return pk.millis == millis && pk.ad_id.equals(ad_id);
  }
}