function Ad(){
	this.stats = new Array();
}

Ad.prototype =
{
	id : null,
	name : null,
	stats : null,
	
	parseFromObject : function( obj ){
		this.id = obj.id;
		this.name = obj.name;
		var stat;
		for(var i in obj.stats){
			stat = new Stat( obj.stats[i] );
			if(stat != null){
				this.stats.push(stat);
			}
			stat = null;
		}
	}
}