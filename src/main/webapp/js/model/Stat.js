function Stat(){

}

Stat.prototype =
{
	millis : null,
	impressions : null,
	ad_id : null,
	
	parseFromObject : function( obj ){
		this.millis = obj.millis;
		this.impressions = obj.impressions;
		this.ad_id = obj.ad_id;
	}
}

