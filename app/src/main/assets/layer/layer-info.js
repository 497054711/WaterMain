$(function(){
	$(".layer-btn").on("click",function(){
		layer.alert('已抢单，请在今日14：00前完成巡检',{
		  	area: ['85%', 'auto'],
		  	closeBtn: 0,//取消右上角关闭图标
		  	title:'提示'
		});
	})
	
	$(".layerout-btn").on("click",function(){
		layer.confirm('放弃任务有可能扣除积分，确认放弃？',{
			btn: ['取消','确定'],
		  	area: ['85%', 'auto'],
		  	closeBtn: 0,//取消右上角关闭图标
		  	title:'提示'
		});
	})
	
})