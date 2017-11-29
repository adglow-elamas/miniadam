package domain;

public class AdSetWithStat {
	
	private AdSet adSet;
	private Stat stat;
	
	public AdSetWithStat(Long adSetId, String adSetName, Long impressions) {
		this.adSet = new AdSet();
		this.adSet.setId(adSetId);
		this.adSet.setName(adSetName);
		this.stat = new Stat();
		stat.setImpressions(impressions);
	}

	public AdSetWithStat(AdSet adSet, Stat stat) {
		this.adSet = adSet;
		this.stat = stat;
	}



	public AdSet getAdSet() {
		return adSet;
	}
	public void setAdSet(AdSet adSet) {
		this.adSet = adSet;
	}
	public Stat getStat() {
		return stat;
	}
	public void setStat(Stat stat) {
		this.stat = stat;
	}
	
}
