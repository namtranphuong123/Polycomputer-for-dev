
app.controller("orderctrl", function($scope, $http, $location){
  $scope.items2 = [];
  $scope.statuses = []
  
  $scope.initialize = function(){
      //load category
    alert("ok")
      $http.get("/rest/orders/Byuser").then(resp => {
          $scope.items2 = resp.data;
    
      });
      $http.get("/rest/statuses").then(resp => {
          $scope.statuses = resp.data;
      });
      $scope.titleForm="Thêm mới Đơn Hàng";
  }
  //khoi dau
  $scope.initialize();

  $scope.details = function(bn){
    
    $http.put(`/order/detail/${bn.orderId}`).then(resp => {
    })
    $scope.initialize();
}

  //xoa form
  $scope.reset= function(){
      $scope.form = {
          statusId : 0
      };
  }
  $scope.fillStatus = true;
  $scope.buttonFill=true;
  // $scope.goToAdd = function(){
  //     $(".nav-tabs a:eq(0)").tab('show')
  //     $scope.titleForm="Thêm mới Đơn Hàng";
  //     $scope.fillStatus = true;
  // }

  //hien thi len form
  $scope.edit = function(item){
      $scope.form = angular.copy(item);
      $scope.titleForm="Cập nhật Đơn Hàng";
      $scope.fillStatus = false;
      $(".nav-tabs a:eq(0)").tab('show')
  }

  //them bp moi
  // $scope.create = function(){
  //     var item = angular.copy($scope.form);
  //     $http.post(`/rest/orders`, item).then(resp => {
  //         $scope.items.push(resp.data);
  //         alert("Thêm mới Đơn Hàng thành công !");
  //     }).catch(error => {
  //         alert("Lỗi thêm mới Đơn Hàng !");
  //         console.log("Error", error);
  //     })
  //     $scope.initialize();
  // }
  //cap nhat bp
  $scope.update = function(){
      var item = angular.copy($scope.form);
      $http.put(`/rest/orders/${item.orderId}`, item).then(resp => {
          var index = $scope.items.findIndex(b => b.orderId == item.orderId);
          $scope.items[index] = item;
          alert("Cập nhật Đơn Hàng thành công !");
      }).catch(error => {
          alert("Lỗi cập nhật Đơn Hàng !");
          console.log("Error", error);
      })
      $scope.initialize();
  }
 
  //xoa bp
  $scope.delete = function(item){
      $http.delete(`/rest/orders/${item.orderId}`).then(resp => {
          var index = $scope.items.findIndex(b => b.orderId == item.orderId);
          $scope.items.splice(index, 1);
          alert("Xóa Đơn Hàng thành công !");
      }).catch(error => {
          alert("Lỗi xóa Đơn Hàng !");
          console.log("Error", error);
      })
      $scope.initialize();
  }

  // phan trang
  $scope.pager = {
      page: 0,
      size: 5,
      get items2(){
          var start = this.page * this.size;
          return $scope.items2.slice(start, start + this.size);
      },
      get count(){
          return Math.ceil(1.0 * $scope.items2.length / this.size);
      },
      first(){
          this.page = 0;
      },
      prev(){
          this.page--;
          if(this.page < 0){
              this.last();
          }
      },
      next(){
          this.page++;
          if(this.page >= this.count){
              this.first();
          }
      },
      last(){
          this.page = this.count - 1;
      }
  }
});