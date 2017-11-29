/*
  {
    "campaign": {
      "id": 1,
      "name": "campaign1"
    },
    "stat": {
      "impressions": 6,
      "ad": null
    }
  } 
 */

function Campaign(){

}

Campaign.prototype =
{
	id : null,
	name : null,
	impressions : null,
	
	parseFromObject : function( obj ){
		this.id = obj.campaign.id;
		this.name = obj.campaign.name;
		this.impressions = obj.stat.impressions;
	}
}

/*
function Campaign(){
	this.adsets = new Array();
}

Campaign.prototype =
{
	id : null,
	name : null,
	adsets : null,
	
	parseFromObject : function( obj ){
		this.id = obj.id;
		this.name = obj.name;
		var adset;
		for(var i in obj.adsets){
			adset = new Adset( obj.adsets[i] );
			if(adset != null){
				this.adsets.push(adset);
			}
			adset = null;
		}
	}
}
*/


