function Model(){
	this.campaigns = new Array();
}


Model.prototype =
{
	campaigns : null,
	
	parseFromObject : function( obj ){
		var campaign;
		for(var i in obj.campaigns){
			campaign = new Campaign( obj.campaigns[i] );
			if(campaign != null){
				this.campaigns.push(campaign);
			}
			campaign = null;
		}
	}
}