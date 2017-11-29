function Adset(){
	this.ads = new Array();
}

Adset.prototype =
{
	id : null,
	name : null,
	ads : null,
	
	parseFromObject : function( obj ){
		this.id = obj.id;
		this.name = obj.name;
		var ad;
		for(var i in obj.ads){
			ad = new Ad( obj.ads[i] );
			if(ad != null){
				this.ads.push(ad);
			}
			ad = null;
		}
	}
}