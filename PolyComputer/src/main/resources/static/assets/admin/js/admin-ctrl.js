app = angular.module("admin-app", ["ngRoute"]);

app.config(function ($routeProvider){
    $routeProvider
    .when("/", {
        templateUrl: "/assets/admin/main-content.html"
    })
     //product
     .when("/authority", {
        templateUrl: "/assets/admin/authority/index.html",
        controller: "authority-ctrl"
    })
    //product
    .when("/product", {
        templateUrl: "/assets/admin/product/index.html",
        controller: "product-ctrl"
    })
    //category
    .when("/category", {
        templateUrl: "/assets/admin/category/index.html",
        controller: "category-ctrl"
    })
    //brand
    .when("/brand", {
        templateUrl: "/assets/admin/brand/index.html",
        controller: "brand-ctrl"
    })
    //banphim
    .when("/banphim", {
        templateUrl: "/assets/admin/banphim/index.html",
        controller: "banphim-ctrl"
    })
    //socongluutrutoida
    .when("/socongluutrutoida", {
        templateUrl: "/assets/admin/socongluutrutoida/index.html",
        controller: "socongluutrutoida-ctrl"
    })
    //ram
    .when("/ram", {
        templateUrl: "/assets/admin/ram/index.html",
        controller: "ram-ctrl"
    })
    //pin
    .when("/pin", {
        templateUrl: "/assets/admin/pin/index.html",
        controller: "pin-ctrl"
    })
    //phukiendikem
    .when("/phukiendikem", {
        templateUrl: "/assets/admin/phukiendikem/index.html",
        controller: "phukiendikem-ctrl"
    })
    //congketnoi
    .when("/congketnoi", {
        templateUrl: "/assets/admin/congketnoi/index.html",
        controller: "congketnoi-ctrl"
    })
    //congxuathinh
    .when("/congxuathinh", {
        templateUrl: "/assets/admin/congxuathinh/index.html",
        controller: "congxuathinh-ctrl"
    })
    //color
    .when("/color", {
        templateUrl: "/assets/admin/color/index.html",
        controller: "color-ctrl"
    })
    //chipdohoa
    .when("/chipdohoa", {
        templateUrl: "/assets/admin/chipdohoa/index.html",
        controller: "chipdohoa-ctrl"
    })
    //cpu
    .when("/cpu", {
        templateUrl: "/assets/admin/cpu/index.html",
        controller: "cpu-ctrl"
    })
    //cpuserie
    .when("/cpuserie", {
        templateUrl: "/assets/admin/cpuserie/index.html",
        controller: "cpuserie-ctrl"
    })
    //manhinh
    .when("/manhinh", {
        templateUrl: "/assets/admin/manhinh/index.html",
        controller: "manhinh-ctrl"
    })
    //luutru
    .when("/luutru", {
        templateUrl: "/assets/admin/luutru/index.html",
        controller: "luutru-ctrl"
    })
    //hedieuhanh
    .when("/hedieuhanh", {
        templateUrl: "/assets/admin/hedieuhanh/index.html",
        controller: "hedieuhanh-ctrl"
    })
    //gift
    .when("/gift", {
        templateUrl: "/assets/admin/gift/index.html",
        controller: "gift-ctrl"
    })
    //binhluan
    .when("/binhluan", {
        templateUrl: "/assets/admin/binhluan/index.html",
        controller: "binhluan-ctrl"
    })
    //binhluan
    .when("/order", {
        templateUrl: "/assets/admin/order/index.html",
        controller: "order-ctrl"
    })
    //statistical-product
    .when("/statistical-product", {
        templateUrl: "/assets/admin/statistical/statistical-product.html",
        // controller: "phukiendikem-ctrl"
    })
    //statistical-boomhang
    .when("/boomhang", {
        templateUrl: "/assets/admin/statistical/statistical-customer-boomhang.html",
        controller: "thongke-boomhang-ctrl"
    })
    .otherwise({
        redirectTo:"/"
    })
})