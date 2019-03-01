package cn.kgc.eat;

import java.util.Scanner;

public class Eat {
	public static void main(String[] args) {
		Scanner input=new Scanner(System.in);		
		System.out.println("\t欢迎使用“吃货联盟订餐系统”");
		String []cp={"红烧带鱼","鱼香肉丝","时令鲜蔬"};//菜品信息
		double []price={38,20,10};//菜品价格
		String []names=new String[4];//保存订餐人信息
		String []dishMegs=new String[4];//保存菜品名及份数
		int []times=new int[4];//保存送餐时间
		String []addresses=new String[4];//保存送餐地址
		int []states=new int[4];//保存订单状态：0已预定，1已完成
		double []sumPrices=new double[4];//保存订单的总金额
		int a=1;//控制do-while循环，a=0时返回菜单，循环停止
		int n=0;//控制数组输出，计数作用
		//int dingdan=0;//接收要签收的订单号
		int good[]=new int[3];//接收点赞的数量
		do{
			System.out.println("******************************");
			System.out.println("1.我要订餐");
			System.out.println("2.查看餐袋");
			System.out.println("3.签收订单");
			System.out.println("4.删除订单");
			System.out.println("5.我要点赞");
			System.out.println("6.退出系统");
			System.out.println("******************************");
			System.out.println("请选择：");
			int key=input.nextInt();
			switch (key) {
			case 1:
				System.out.println("***我要订餐***");
				System.out.println("请输入订餐人姓名：");
				if(n<4){
					names[n]=input.next();
					System.out.println("序号\t菜名\t单价");
					for(int i=0;i<3;i++){
						System.out.println((i+1)+"\t"+cp[i]+"\t"+price[i]+"元");
					}
					System.out.println("请选择你你要点的菜品编号：");
					int cpNo=input.nextInt();
					System.out.println("请选择你要点的份数：");
					int count=input.nextInt();
					dishMegs[n]=cp[cpNo-1]+count+"份";
					System.out.println("请输入送餐时间（请输入10到22之间的整点）");
					int time=0;
					time=input.nextInt();
					while(time<10 || time>22){
						System.out.println("您的输入有误，请输入10到22之间的整点");
						time=input.nextInt();
					}
					times[n]=time;
					states[n]=0;
					System.out.println("请输入送餐地址：");
					addresses[n]=input.next();
					System.out.println("订餐成功！");
					System.out.println("您订的是："+dishMegs[n]);
					System.out.println("送餐时间："+times[n]+"点");
					double sumPrice=price[cpNo-1]*count;
					if(sumPrice>=50){
						sumPrices[n]=sumPrice;
						System.out.println("餐费："+sumPrice+"元，送餐费0元，" +
								"总计："+sumPrices[n]+"元");
					}else{
						sumPrices[n]=sumPrice+6;
						System.out.println("餐费："+sumPrice+"元，送餐费6元，" +
								"总计："+sumPrices[n]+"元");
					}	
				}else{
					System.out.println("订单已满");
				}
				n++;
				break;
			case 2:
				System.out.println("***查看餐袋***");
				System.out.println("序号\t订餐人\t餐品信息\t" +
						"\t送餐时间\t送餐地址\t总金额\t订单状态");
				for (int i = 0; i < names.length; i++) {
					if(names[i]==null){
						break;
					}
					String state="";
					if(states[i]==0){
						state="已预定";
					}else {
						state="已完成";
					}
					System.out.println((i+1)+"\t"+names[i]+"\t"
					+dishMegs[i]+"\t"+times[i]+"\t"+addresses[i]
					+"\t"+sumPrices[i]+"元\t"+state);
				}
				break;
			case 3:
				System.out.println("***签收订单***");
				System.out.println("请选择要签收的订单号：");
				int mark=input.nextInt();
				states[mark-1]=1;
				System.out.println("订单签收成功！");
				break;
			case 4:
				System.out.println("***删除订单***");
				System.out.println("请输入要删除的订单序号：");
				int del=input.nextInt();
				if(del>4 || del<1){
					System.out.println("该订单不存在！");
				}else if(states[del-1]==0){
					System.out.println("您选择的订单未签收，不能删除");	
				}else{
					for (int i = (del-1); i < 3; i++) {
						names[i]=names[i+1];
						dishMegs[i]=dishMegs[i+1];
						times[i]=times[i+1];
						addresses[i]=addresses[i+1];
						states[i]=states[i+1];
						sumPrices[i]=sumPrices[i+1];
					}
					names[3]=null;
					dishMegs[3]=null;
					times[3]=0;
					addresses[3]=null;
					states[3]=0;
					sumPrices[3]=0;
					System.out.println("删除订单成功！");
				}
				break;
			case 5:
				System.out.println("***我要点赞***");
				System.out.println("序号\t菜名\t单价");
				for (int i = 0; i < good.length; i++) {
					System.out.println((i+1)+"\t"+cp[i]+
							"\t"+price[i]+"元\t"+good[i]+"赞");
				}
				System.out.println("请选择您要点赞的菜品序号：");
				int great=input.nextInt();
				good[great-1]++;
				System.out.println("点赞成功！");
				break;
			case 6:
				System.out.println("谢谢使用，欢迎下次光临！");
				return;
			}
			System.out.println("输入“0”返回上一页");
			a=input.nextInt();
		}while(a==0);
	}
}
