'use strict';

myApp
.config(['$routeProvider', function($routeProvider) {
  $routeProvider.when('/home', {
    templateUrl: 'home/home.html',
    controller: 'HomeController'
  });
}])

.controller('HomeController', ['$scope', '$http', function($scope, $http) {
	console.log("[HomeController]");
	console.log("[HomeController]$scope.model: ");
	console.log($scope.model);
	//meto las categorias en el modelo solo si no estaba ya. De esta manera si navego por la app no se hacen llamasas ajax innecesarias
	//if ($scope.model.categories == null || $scope.model.categories.length == 0) {
		$http({
		  method: 'GET',
		  //url: 'fake-ajax/get-campaigns.html'
		  url: '/backend/campaignswithstat'
		}).then(function successCallback(response) {
			console.log("[HomeController] successCallback");
			var campaign;
			for(var i in response.data){
				campaign = new Campaign();
				campaign.parseFromObject(response.data[i]);
				if(campaign != null){
					$scope.model.campaigns.push(campaign);
				}
				campaign = null;
			}
			
		  }, function errorCallback(response) {
			console.log("[HomeController] errorCallback");
		  });
		
		
		  $('#newCampaign').on('click', function (e) {
		       $scope.createCampaign($('#campaignName').val());
		   });				  
		  
		  $scope.createCampaign = function(campaignName) {
				$http({
					  method: 'POST',
					  url: '/backend/campaigns',
					  data: '{"name": "' + campaignName + '"}',
					  headers: {'Content-Type': 'application/json; charset=UTF-8'}		  
					}).then(function successCallback(response) {
						console.log("[HomeController] successCallback insert");
						$scope.model.campaigns.push(response.data);
					  }, function errorCallback(response) {
						console.log("[HomeController] errorCallback insert");
					  });	
			  };	
			  
		  $scope.deleteCampaign = function(id) {
				$http({
					  method: 'DELETE',
					  url: '/backend/campaigns/' + id
					}).then(function successCallback(response) {
						console.log("[HomeController] successCallback delete");
						for(var i = $scope.model.campaigns.length - 1; i >= 0; i--) {
						    if($scope.model.campaigns[i].id == id) {
						    	$scope.model.campaigns.splice(i, 1);
						    }
						}						
					  }, function errorCallback(response) {
						console.log("[HomeController] errorCallback delete");
					  });	
			  };
			  
			  $scope.setForEditCampaign = function(id) {
				  //var e = document.getElementById(id);
				  //e.innerHTML = '<input type="text" id="newValue"/><input type="button" value="Accept" onClick="updateCampaign"/>';
				  //e.innerHTML = '<input type="text" id="newValue"/><input type="button" value="Accept" ng-click="updateCampaign()"/>';
				  var e1 = document.getElementById("oldValue-" + id + "-span");
				  var e2 = document.getElementById("newValue-" + id + "-span");
				  e1.style.display = "none";
				  e2.style.display = "block";
			  }

			  $scope.updateCampaign = function(id) {
				  //alert("[updateCampaign] id: " + id);
					$http({
						  method: 'PUT',
						  url: '/backend/campaigns/' + id,
						  data: '{"name": "' + document.getElementById("newValue-" + id).value + '"}',
						  headers: {'Content-Type': 'application/json; charset=UTF-8'}		  
						}).then(function successCallback(response) {
							console.log("[HomeController] successCallback delete");
							//no actualizo el modelo por no perder tiempo, solo lo pinto
							  var e1 = document.getElementById("oldValue-" + id + "-span");
							  e1.innerHTML = document.getElementById("newValue-" + id).value;
							  var e2 = document.getElementById("newValue-" + id + "-span");
							  e1.style.display = "block";
							  e2.style.display = "none";
							/*
							for(var i = $scope.model.campaigns.length - 1; i >= 0; i--) {
							    if($scope.model.campaigns[i].id == id) {
							    	$scope.model.campaigns.splice(i, 1);
							    }
							}
							*/						
						  }, function errorCallback(response) {
							console.log("[HomeController] errorCallback delete");
						  });	
				  
			  }
			  
	//}
}]);



