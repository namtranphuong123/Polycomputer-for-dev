
const app = angular.module("shopping-cart-app", []);
app.controller("shopping-cart-ctrl", function ($scope, $http) {





	$scope.cart = {
		items: [],
		add(productId) {

			Swal.fire({
				icon: 'success',
				title: 'Thành công',
				text: 'Sản phẩm đã được thêm vào giỏ hàng!',
			})

			var item = this.items.find(item => item.productId == productId);
			if (item) {
				item.qty++;
				this.saveToLocalStorage();
			} else {
				$http.get(`/rest/products/${productId}`).then(resp => {
					resp.data.qty = 1;
					this.items.push(resp.data);
					this.saveToLocalStorage();

				})
			}
		},
		muangay(productId) {
			Swal.fire({
				icon: 'success',
				title: 'Thành công',
				text: 'Sản phẩm đã được thêm vào giỏ hàng!',
			})

			var item = this.items.find(item => item.productId == productId);
			if (item) {
				item.qty++;
				this.saveToLocalStorage();


			} else {
				$http.get(`/rest/products/${productId}`).then(resp => {
					resp.data.qty = 1;
					this.items.push(resp.data);
					this.saveToLocalStorage();

				})
			}
		},

		remove(productId) {
			var index = this.items.findIndex(item => item.productId == productId);
			this.items.splice(index, 1);
			this.saveToLocalStorage();
			Swal.fire({
				icon: 'success',
				title: 'Thành công',
				text: 'Đã xóa sản phẩm khỏi giỏ hàng!',
			})


		},
		clear(productId) {
			this.items = []
			this.saveToLocalStorage();

		},
		atm_of(item) { },
		get count() {
			return this.items
				.map(item => item.qty)
				.reduce((total, qty) => total += qty, 0);
		},
		get amount() {
			return this.items
				.map(item => item.qty * (item.gia - item.giamGia))
				.reduce((total, qty) => total += qty, 0);
		},
		get tong() {
			return this.items
				.map(item => item.qty * item.gia)
				.reduce((total, qty) => total += qty, 0);
		},
		get giamgia() {
			return this.items
				.map(item => item.qty * item.giamGia)
				.reduce((total, qty) => total += qty, 0);
		},

		saveToLocalStorage() {
			var json = JSON.stringify(angular.copy(this.items));
			localStorage.setItem("cart", json);
		},

		loadFromLocalStorage() {
			var json = localStorage.getItem("cart");
			this.items = json ? JSON.parse(json) : [];
		},


	}


	$scope.cart.loadFromLocalStorage();


	
	$scope.order = {

		createdAt: new Date(),
		address: "",
		phoneNumber: "",
		description: "",
		fullName: "",
		statusId: {
			statusId: 1,
		},
		tongTienThanhToan: $scope.cart.amount,

		account: {
			username: $("#username").text(),


		},
		get orderDetails() {
			return $scope.cart.items.map(item => {
				return {
					productId: { productId: item.productId },
					gia: item.gia,
					tongTienSanPham: (item.gia - item.giamGia) * item.qty,
					soLuong: item.qty,

				}
			});
		},




		purchase() {
			var order = angular.copy(this);
			$http.post("/rest/orders", order).then(resp => {


				$scope.cart.clear();

			

				let timerInterval
				Swal.fire({
					icon: 'success',
					title: 'Thành công',
					text: 'Đặt hàng thành công!',
					timer: 2000,
					timerProgressBar: true,
					didOpen: () => {
						Swal.showLoading()
					
					
					},
					willClose: () => {
						clearInterval(timerInterval)
					}
				}).then((result) => {
					/* Read more about handling dismissals below */
					if (result.dismiss === Swal.DismissReason.timer) {
						console.log('I was closed by the timer')
						location.href = "/order/detail/" + resp.data.orderId;
					}
				})

				

				

			}).catch(error => {
				Swal.fire({
					icon: 'error',
					title: 'Thất bại',
					text: 'Đặt hàng thất bại !',
				})

				console.log(error)
			})
		},





	}
	$scope.update = function () {
		orderId = $("#orderId").text(),

			$http.get(`/rest/orders/updateStatus/${orderId}`).then(resp => {
				Swal.fire({
					icon: 'success',
					title: 'Thành công',
					text: 'Hủy Đơn Hàng thành công !',
				})


			}).catch(error => {
				Swal.fire({
					icon: 'error',
					title: 'Thất bại',
					text: 'Lỗi Hủy Đơn Hàng !',
				})

				console.log("Error", error);
			})
		$scope.initialize();
	}



})
