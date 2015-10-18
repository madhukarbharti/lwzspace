var angular = angular.module('pagesDirective', []);
angular.directive('myPagination', ['$compile', function($compile) {
	return {
		restrict: 'A',
		controller: ['$scope', '$filter','$compile',
			function($scope, $filter, $compile) {
				//$scope.buildDataMap = buildPageData;
				//$scope.name = 'xxxxx';
				this.buildDataMap = function(dataList, pageSize) {
					var pageNo = 0;
					var pageData = [];
					var pageDataMap = {};
					$.each(dataList, function(index, value) {
						pageData.push(value);
						if (pageData.length >= pageSize) {
							pageDataMap[++pageNo] = pageData;
							pageData = []
						} else if (index == dataList.length - 1) {
							pageDataMap[++pageNo] = pageData;
						}

					});
					return pageDataMap;
				};
				alert(33333);
			}
		],
		link: function(scope, element, attrs, controller) {
			//alert(scope.name);

			var pageSize = $(element).attr('pageSize');
			if ((typeof pageSize) == 'string') {
				pageSize = parseInt(pageSize);
			}
			var list = $(element).attr("pageData");
			var tempSize = Math.round(scope[list].length / pageSize);
			scope.maxPageNo = ((scope[list].length) % pageSize) == 0 ? tempSize : tempSize + 1;

			scope.pageDataMap = controller.buildDataMap(scope[list], pageSize);

			scope.curPageNo = 1;
			scope.curData = scope.pageDataMap[scope.curPageNo]
			console.log(scope.curData);
			scope.previousPageNo = function() {
				if (scope.curPageNo > 1) {
					--scope.curPageNo;
				}
			}
			scope.nextPageNo = function() {
				if (scope.curPageNo < scope.maxPageNo) {
					++scope.curPageNo;
				}
			}
//			console.log(scope)
			scope.$watch('curPageNo', function(newValue, oldValue) {
				scope.curData = scope.pageDataMap[newValue];
			});
		}
	}
}]).controller('test', ['$scope', '$filter', '$compile',
	function($scope, $filter, $compile) {
		$scope.load = function() {
			return loadData();
		}
		var originData = $scope.load();
		$scope.xq = originData;
		$scope.filterKey = 'mary'
		$scope.xq = $filter('filter')(originData, $scope.filterKey);
		$scope.search = function(filterKey) {
			console.log(filterKey);
			$scope.xq = $filter('filter')(originData, filterKey);
//			var v = $compile($('#pa'))($scope);
//			$("#parent").contents().remove();
//			$("#parent").append(v);
		}
	}
]);


function loadData() {
	var data = [];
	for (var i = 0; i < 200; i++) {
		data.push({
			name: i + '-John-' + new Date(),
			phone: '555-1276'
		})
		data.push({
			name: i + '-Mary-' + new Date(),
			phone: '444-1276'
		})
		data.push({
			name: i + '-Mike-' + new Date(),
			phone: '333-1276'
		})
		data.push({
			name: i + '-Adam-' + new Date(),
			phone: '888-1276'
		})
	}
	return data;
}