$(document).ready(function(){

	introMove();
	function introMove() {
		TweenLite.from($("#intro .el1"), 1, {css:{top: 210, left: 150}, delay:0.5});
		TweenLite.from($("#intro .el2"), 1, {css:{top: 210, left: 150}, delay:0.6});
		TweenLite.from($("#intro .el3"), 1, {css:{top: 210, left: 150}, delay:0.7});
		TweenLite.from($("#intro .el4"), 1, {css:{top: 210, left: 150}, delay:0.8});
		TweenLite.from($("#intro .el5"), 1, {css:{top: 210, left: 150}, delay:0.9});
		TweenLite.from($("#intro .el6"), 1, {css:{top: 210, left: 150}, delay:1});
		TweenLite.from($("#intro .el7"), 1, {css:{top: 210, left: 150}, delay:1.1});
		TweenLite.from($("#intro .el8"), 1, {css:{top: 210, left: 150}, delay:1.2});
		TweenLite.from($("#intro .el9"), 1, {css:{top: 210, left: 150}, delay:1.3});
		TweenLite.from($("#intro .el10"), 1, {css:{top: 210, left: 150}, delay:1.4});
		TweenLite.from($("#intro .el11"), 1, {css:{top: 210, left: 150}, delay:1.5});
		TweenLite.from($("#intro .el12"), 1, {css:{top: 210, left: 150}, delay:1.6});
		TweenLite.from($("#intro .el13"), 1, {css:{top: 210, left: 150}, delay:1.7});
		TweenLite.from($("#intro .electro"), 0.5, {css:{top: 200}, onComplete:introMoveEnd});
		$("#intro .electro").show();
	}
	function introMoveEnd(){
		eleRandomMove("start");	
	}
	var interval_ele;
	function eleRandomMove(type){
		if(type == "start"){
			clearInterval(interval_ele);
			interval_ele = setInterval(function () {
				TweenLite.to($("#intro .el1"), 1, {css:{top: Math.floor(Math.random() * 30 +(70)), left: Math.floor(Math.random() * 30 +(20))}});
				TweenLite.to($("#intro .el2"), 1, {css:{top: Math.floor(Math.random() * 20 +(40)), left: Math.floor(Math.random() * 30 +(120))}});
				TweenLite.to($("#intro .el3"), 1, {css:{top: Math.floor(Math.random() * 30 +(120)), left: Math.floor(Math.random() * 30 +(40))}});
				TweenLite.to($("#intro .el4"), 1, {css:{top: Math.floor(Math.random() * 20 +(10)), left: Math.floor(Math.random() * 30 +(270))}});
				TweenLite.to($("#intro .el5"), 1, {css:{top: Math.floor(Math.random() * 10 +(90)), left: Math.floor(Math.random() * 30 +(280))}});
				TweenLite.to($("#intro .el6"), 1, {css:{top: Math.floor(Math.random() * 10 +(50)), left: Math.floor(Math.random() * 30 +(310))}});
				TweenLite.to($("#intro .el7"), 1, {css:{top: Math.floor(Math.random() * 10 +(60)), left: Math.floor(Math.random() * 30 +(420))}});
				TweenLite.to($("#intro .el8"), 1, {css:{top: Math.floor(Math.random() * 10 +(200)), left: Math.floor(Math.random() * 30 +(380))}});
				TweenLite.to($("#intro .el9"), 1, {css:{top: Math.floor(Math.random() * 10 +(210)), left: Math.floor(Math.random() * 30 +(300))}});
				TweenLite.to($("#intro .el10"), 1, {css:{top: Math.floor(Math.random() * 10 +(290)), left: Math.floor(Math.random() * 30 +(270))}});
				TweenLite.to($("#intro .el11"), 1, {css:{top: Math.floor(Math.random() * 10 +(230)), left: Math.floor(Math.random() * 30 +(40))}});
				TweenLite.to($("#intro .el12"), 1, {css:{top: Math.floor(Math.random() * 10 +(240)), left: Math.floor(Math.random() * 30 +(120))}});
				TweenLite.to($("#intro .el13"), 1, {css:{top: Math.floor(Math.random() * 10 +(280)), left: Math.floor(Math.random() * 30 +(20))}});
			}, 800);
		}else{
			clearInterval(interval_ele);
		}
	}
})