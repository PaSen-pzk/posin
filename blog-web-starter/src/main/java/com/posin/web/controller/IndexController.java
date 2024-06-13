package com.posin.web.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.posin.web.service.BlogGlobalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.UUID;

/**
 * @author zkP
 * @date 2024/1/22 21:09
 * @func
 * @description
 */
@Controller
public class IndexController {

    @Autowired
    private BlogGlobalService blogGlobalService;

    @GetMapping("/")
    public ModelAndView defaultPage(){
        return new ModelAndView("redirect:/index");
    }

    @GetMapping("/login_")
    public ModelAndView login_(){
        return new ModelAndView("login_");
    }

    @GetMapping("/login")
    public ModelAndView login(){
        return new ModelAndView("login");
    }

    @GetMapping("/index")
    public ModelAndView index(){
        ModelAndView mv = new ModelAndView("sys/index");
        mv.addObject("GLOBAL_CONFIG", JSON.toJSONString(blogGlobalService.getGlobalServices()));
        String tempMenuStr = "[{\\\"id\\\":\\\"00836971-f4bb-4766-9d10-cf3abb428dae\\\",\\\"moduleId\\\":\\\"c0544bfd-a557-45fc-a856-a678a1e88bfc\\\",\\\"parentId\\\":\\\"b5cb98f6-fb41-4a0f-bc11-469ff117a411\\\",\\\"enCode\\\":\\\"FlowDelegate\\\",\\\"fullName\\\":\\\"流程指派\\\",\\\"icon\\\":\\\"fa fa-random\\\",\\\"urlAddress\\\":null,\\\"target\\\":\\\"iframe\\\",\\\"role\\\":6},{\\\"id\\\":\\\"048ed456-a116-446b-abc6-084e1c8543cd\\\",\\\"moduleId\\\":\\\"f63a252b-975f-4832-a5be-1ce733bc8ece\\\",\\\"parentId\\\":\\\"458113c6-b0be-4d6f-acce-7524f4bc3e88\\\",\\\"enCode\\\":\\\"FlowDesign\\\",\\\"fullName\\\":\\\"流程设计\\\",\\\"icon\\\":\\\"fa fa-share-alt\\\",\\\"urlAddress\\\":null,\\\"target\\\":\\\"iframe\\\",\\\"role\\\":6},{\\\"id\\\":\\\"07af742f-3a6e-4f8b-ad77-c100ca60a177\\\",\\\"moduleId\\\":\\\"2f820f6e-ae2e-472f-82cc-0129a2a57597\\\",\\\"parentId\\\":\\\"7cec0a0f-7204-4240-b009-312fa0c11cbf\\\",\\\"enCode\\\":\\\"DataBaseTable\\\",\\\"fullName\\\":\\\"数据表管理\\\",\\\"icon\\\":\\\"fa fa-table\\\",\\\"urlAddress\\\":null,\\\"target\\\":\\\"iframe\\\",\\\"role\\\":6},{\\\"id\\\":\\\"0ecade22-41a3-4247-98f7-5413cf75da67\\\",\\\"moduleId\\\":\\\"ff1823b5-a966-4e6c-83de-807854f4f0fb\\\",\\\"parentId\\\":\\\"6\\\",\\\"enCode\\\":\\\"SalesReport\\\",\\\"fullName\\\":\\\"销售报表\\\",\\\"icon\\\":\\\"fa fa-line-chart\\\",\\\"urlAddress\\\":null,\\\"target\\\":\\\"iframe\\\",\\\"role\\\":6},{\\\"id\\\":\\\"10e7859c-9f89-4755-8d4b-3aaaa78791a5\\\",\\\"moduleId\\\":\\\"23713d3a-810f-422d-acd5-39bec28ce47e\\\",\\\"parentId\\\":\\\"4\\\",\\\"enCode\\\":\\\"ScheduleManage\\\",\\\"fullName\\\":\\\"日程管理\\\",\\\"icon\\\":\\\"fa fa-calendar\\\",\\\"urlAddress\\\":null,\\\"target\\\":\\\"iframe\\\",\\\"role\\\":6},{\\\"id\\\":\\\"1293282d-eeec-4052-9eb1-e10e2c014328\\\",\\\"moduleId\\\":\\\"cfa631fe-e7f8-42b5-911f-7172f178a811\\\",\\\"parentId\\\":\\\"1\\\",\\\"enCode\\\":\\\"CodeCreate\\\",\\\"fullName\\\":\\\"快速开发\\\",\\\"icon\\\":\\\"fa fa-code\\\",\\\"urlAddress\\\":null,\\\"target\\\":\\\"iframe\\\",\\\"role\\\":6},{\\\"id\\\":\\\"12c995fc-67ee-4287-ad53-6cc1f36ef7ec\\\",\\\"moduleId\\\":\\\"52fe82f8-41ba-433e-9351-ef67e5b35217\\\",\\\"parentId\\\":\\\"16d4e2d5-d154-455f-94f7-63bf80ab26aa\\\",\\\"enCode\\\":\\\"Client_Level\\\",\\\"fullName\\\":\\\"客户级别\\\",\\\"icon\\\":\\\"fa fa-tag\\\",\\\"urlAddress\\\":null,\\\"target\\\":\\\"iframe\\\",\\\"role\\\":6},{\\\"id\\\":\\\"15c776b3-a436-48d3-9d80-a18a2ca6b8c5\\\",\\\"moduleId\\\":\\\"9\\\",\\\"parentId\\\":\\\"2\\\",\\\"enCode\\\":\\\"DepartmentManage\\\",\\\"fullName\\\":\\\"部门管理\\\",\\\"icon\\\":\\\"fa fa-th-list\\\",\\\"urlAddress\\\":null,\\\"target\\\":\\\"iframe\\\",\\\"role\\\":6},{\\\"id\\\":\\\"1801ecd7-3ea5-4622-8175-b18d951f3d8d\\\",\\\"moduleId\\\":\\\"1d3797f6-5cd2-41bc-b769-27f2513d61a9\\\",\\\"parentId\\\":\\\"ad147f6d-613f-4d2d-8c84-b749d0754f3b\\\",\\\"enCode\\\":\\\"ClientInfoManage\\\",\\\"fullName\\\":\\\"客户管理\\\",\\\"icon\\\":\\\"fa fa-suitcase\\\",\\\"urlAddress\\\":null,\\\"target\\\":\\\"iframe\\\",\\\"role\\\":6},{\\\"id\\\":\\\"1a41d4a7-d0f9-4435-a851-b7a82e93057c\\\",\\\"moduleId\\\":\\\"1ef31fba-7f0a-46f7-b533-49dd0c2e51e0\\\",\\\"parentId\\\":\\\"ad147f6d-613f-4d2d-8c84-b749d0754f3b\\\",\\\"enCode\\\":\\\"ClienReceivableReport\\\",\\\"fullName\\\":\\\"收款报表\\\",\\\"icon\\\":\\\"fa fa-bar-chart\\\",\\\"urlAddress\\\":null,\\\"target\\\":\\\"iframe\\\",\\\"role\\\":6},{\\\"id\\\":\\\"1f03bb17-0e0e-4de4-a9f2-1c12dfe034ee\\\",\\\"moduleId\\\":\\\"6252983c-52f5-402c-991b-ad19a9cb1f94\\\",\\\"parentId\\\":\\\"4\\\",\\\"enCode\\\":\\\"NoticeManage\\\",\\\"fullName\\\":\\\"发件数量\\\",\\\"icon\\\":\\\"fa fa-volume-up\\\",\\\"urlAddress\\\":null,\\\"target\\\":\\\"iframe\\\",\\\"role\\\":6},{\\\"id\\\":\\\"212050bd-7393-4225-ab4a-e7eb1931999f\\\",\\\"moduleId\\\":\\\"aa844d70-7211-41d9-907a-f9a10f4ac801\\\",\\\"parentId\\\":\\\"b9f9df92-8ac5-46e2-90ac-68c5c2e034c3\\\",\\\"enCode\\\":\\\"企业号应用\\\",\\\"fullName\\\":\\\"企业号应用\\\",\\\"icon\\\":\\\"fa fa-safari\\\",\\\"urlAddress\\\":null,\\\"target\\\":\\\"iframe\\\",\\\"role\\\":6},{\\\"id\\\":\\\"29af5756-dece-401e-86cf-e00d4cd4165e\\\",\\\"moduleId\\\":\\\"9fc384f5-efb7-439e-9fe1-3e50807e6399\\\",\\\"parentId\\\":\\\"ad147f6d-613f-4d2d-8c84-b749d0754f3b\\\",\\\"enCode\\\":\\\"ClienExpenses\\\",\\\"fullName\\\":\\\"支出管理\\\",\\\"icon\\\":\\\"fa fa-credit-card-alt\\\",\\\"urlAddress\\\":null,\\\"target\\\":\\\"iframe\\\",\\\"role\\\":6},{\\\"id\\\":\\\"2dd3f7a3-0d1b-4f3c-8145-6d23f754d01b\\\",\\\"moduleId\\\":\\\"00ae31cf-b340-4c17-9ee7-6dd08943df02\\\",\\\"parentId\\\":\\\"458113c6-b0be-4d6f-acce-7524f4bc3e88\\\",\\\"enCode\\\":\\\"FormCategory\\\",\\\"fullName\\\":\\\"表单类别\\\",\\\"icon\\\":\\\"fa fa-tags\\\",\\\"urlAddress\\\":null,\\\"target\\\":\\\"iframe\\\",\\\"role\\\":6},{\\\"id\\\":\\\"2e40d9c8-1d9e-4231-83f9-1b48d018dd2a\\\",\\\"moduleId\\\":\\\"1\\\",\\\"parentId\\\":\\\"0\\\",\\\"enCode\\\":\\\"SysManage\\\",\\\"fullName\\\":\\\"系统管理\\\",\\\"icon\\\":\\\"fa fa-desktop\\\",\\\"urlAddress\\\":null,\\\"target\\\":\\\"iframe\\\",\\\"role\\\":6},{\\\"id\\\":\\\"30b7bda0-97a5-4ac0-8310-2dfcb9d22f91\\\",\\\"moduleId\\\":\\\"12\\\",\\\"parentId\\\":\\\"2\\\",\\\"enCode\\\":\\\"JobManage\\\",\\\"fullName\\\":\\\"职位管理\\\",\\\"icon\\\":\\\"fa fa-briefcase\\\",\\\"urlAddress\\\":null,\\\"target\\\":\\\"iframe\\\",\\\"role\\\":6},{\\\"id\\\":\\\"34d1d215-a69c-40de-976f-a1f9fed6d127\\\",\\\"moduleId\\\":\\\"4efd37bf-e3ef-4ced-8248-58eba046d78b\\\",\\\"parentId\\\":\\\"1\\\",\\\"enCode\\\":\\\"DataItemManage\\\",\\\"fullName\\\":\\\"测试数据\\\",\\\"icon\\\":\\\"fa fa-book\\\",\\\"urlAddress\\\":null,\\\"target\\\":\\\"iframe\\\",\\\"role\\\":6},{\\\"id\\\":\\\"36c3af4a-b276-4023-ac02-d19958e7e4e9\\\",\\\"moduleId\\\":\\\"14\\\",\\\"parentId\\\":\\\"2\\\",\\\"enCode\\\":\\\"UserGroupManage\\\",\\\"fullName\\\":\\\"用户组管理\\\",\\\"icon\\\":\\\"fa fa-group\\\",\\\"urlAddress\\\":null,\\\"target\\\":\\\"iframe\\\",\\\"role\\\":6},{\\\"id\\\":\\\"43faf0fc-1e8d-4c2f-b535-78178cadfb26\\\",\\\"moduleId\\\":\\\"92a535c9-4d4b-4500-968d-a142e671c09b\\\",\\\"parentId\\\":\\\"6\\\",\\\"enCode\\\":\\\"ReportTemp\\\",\\\"fullName\\\":\\\"报表管理\\\",\\\"icon\\\":\\\"fa fa-cogs\\\",\\\"urlAddress\\\":null,\\\"target\\\":\\\"iframe\\\",\\\"role\\\":6},{\\\"id\\\":\\\"451640e6-c494-42d6-94b9-9b4858388e65\\\",\\\"moduleId\\\":\\\"62af0605-4558-47b1-9530-bc3515036b37\\\",\\\"parentId\\\":\\\"16d4e2d5-d154-455f-94f7-63bf80ab26aa\\\",\\\"enCode\\\":\\\"Client_PaymentAccount\\\",\\\"fullName\\\":\\\"收支账户\\\",\\\"icon\\\":\\\"fa fa-tag\\\",\\\"urlAddress\\\":null,\\\"target\\\":\\\"iframe\\\",\\\"role\\\":6},{\\\"id\\\":\\\"4859c497-99e3-4908-ad7e-bea9e6fc5eec\\\",\\\"moduleId\\\":\\\"10\\\",\\\"parentId\\\":\\\"2\\\",\\\"enCode\\\":\\\"UserManage\\\",\\\"fullName\\\":\\\"用户管理\\\",\\\"icon\\\":\\\"fa fa-user\\\",\\\"urlAddress\\\":null,\\\"target\\\":\\\"iframe\\\",\\\"role\\\":6},{\\\"id\\\":\\\"4af61587-65d9-4a12-bd2f-7d556866012c\\\",\\\"moduleId\\\":\\\"77f13de5-32ad-4226-9e24-f1db507e78cb\\\",\\\"parentId\\\":\\\"16d4e2d5-d154-455f-94f7-63bf80ab26aa\\\",\\\"enCode\\\":\\\"Client_PaymentMode\\\",\\\"fullName\\\":\\\"收支方式\\\",\\\"icon\\\":\\\"fa fa-tag\\\",\\\"urlAddress\\\":null,\\\"target\\\":\\\"iframe\\\",\\\"role\\\":6},{\\\"id\\\":\\\"4b1210bb-c7df-4cfe-ac4c-5933dbca4088\\\",\\\"moduleId\\\":\\\"b0261df5-7be0-4c8e-829c-15836e200af0\\\",\\\"parentId\\\":\\\"1\\\",\\\"enCode\\\":\\\"SystemForm\\\",\\\"fullName\\\":\\\"系统表单\\\",\\\"icon\\\":\\\"fa fa-paw\\\",\\\"urlAddress\\\":null,\\\"target\\\":\\\"iframe\\\",\\\"role\\\":6},{\\\"id\\\":\\\"510a3239-af45-4274-841a-1fbdce9a81a5\\\",\\\"moduleId\\\":\\\"f21fa3a0-c523-4d02-99ca-fd8dd3ae3d59\\\",\\\"parentId\\\":\\\"1\\\",\\\"enCode\\\":\\\"SystemLog\\\",\\\"fullName\\\":\\\"系统日志\\\",\\\"icon\\\":\\\"fa fa-warning\\\",\\\"urlAddress\\\":null,\\\"target\\\":\\\"iframe\\\",\\\"role\\\":6},{\\\"id\\\":\\\"52b180cb-cd9a-41a0-9060-f2eaa2d2e97f\\\",\\\"moduleId\\\":\\\"66f6301c-1789-4525-a7d2-2b83272aafa6\\\",\\\"parentId\\\":\\\"ad147f6d-613f-4d2d-8c84-b749d0754f3b\\\",\\\"enCode\\\":\\\"ClientChance\\\",\\\"fullName\\\":\\\"商机管理\\\",\\\"icon\\\":\\\"fa fa-binoculars\\\",\\\"urlAddress\\\":null,\\\"target\\\":\\\"iframe\\\",\\\"role\\\":6},{\\\"id\\\":\\\"52fc9c11-a5fc-4ad7-bf94-6ee15d1f4c2a\\\",\\\"moduleId\\\":\\\"7ae94059-9aa5-48eb-8330-4e2a6565b193\\\",\\\"parentId\\\":\\\"1\\\",\\\"enCode\\\":\\\"AreaManage\\\",\\\"fullName\\\":\\\"服务监控\\\",\\\"icon\\\":\\\"fa fa-leaf\\\",\\\"urlAddress\\\":null,\\\"target\\\":\\\"iframe\\\",\\\"role\\\":8},{\\\"id\\\":\\\"5361ba21-da3f-4a15-abe7-248f6ffaf414\\\",\\\"moduleId\\\":\\\"08dfd779-92d5-4cd8-9982-a76176af0f7c\\\",\\\"parentId\\\":\\\"458113c6-b0be-4d6f-acce-7524f4bc3e88\\\",\\\"enCode\\\":\\\"FlowCategory\\\",\\\"fullName\\\":\\\"流程类别\\\",\\\"icon\\\":\\\"fa fa-tags\\\",\\\"urlAddress\\\":null,\\\"target\\\":\\\"iframe\\\",\\\"role\\\":6},{\\\"id\\\":\\\"54ba32f6-1895-416d-8905-981180089580\\\",\\\"moduleId\\\":\\\"eab4a37f-d976-42b7-9589-489ed0678151\\\",\\\"parentId\\\":\\\"16d4e2d5-d154-455f-94f7-63bf80ab26aa\\\",\\\"enCode\\\":\\\"Client_ExpensesType\\\",\\\"fullName\\\":\\\"支出种类\\\",\\\"icon\\\":\\\"fa fa-tag\\\",\\\"urlAddress\\\":null,\\\"target\\\":\\\"iframe\\\",\\\"role\\\":6},{\\\"id\\\":\\\"54d9e163-6bc5-435b-9393-3fde434d61f5\\\",\\\"moduleId\\\":\\\"7adc5a16-54a4-408e-a101-2ddab8117d67\\\",\\\"parentId\\\":\\\"1\\\",\\\"enCode\\\":\\\"CodeRule\\\",\\\"fullName\\\":\\\"系统日志\\\",\\\"icon\\\":\\\"fa fa-barcode\\\",\\\"urlAddress\\\":null,\\\"target\\\":\\\"iframe\\\",\\\"role\\\":6},{\\\"id\\\":\\\"5b749217-bad9-42a6-8d5b-9d60a9076fd2\\\",\\\"moduleId\\\":\\\"ad147f6d-613f-4d2d-8c84-b749d0754f3b\\\",\\\"parentId\\\":\\\"0\\\",\\\"enCode\\\":\\\"CustomerManage\\\",\\\"fullName\\\":\\\"客户关系\\\",\\\"icon\\\":\\\"fa fa-briefcase\\\",\\\"urlAddress\\\":null,\\\"target\\\":\\\"expand\\\",\\\"role\\\":0},{\\\"id\\\":\\\"5da38d6f-5130-4e1e-a41f-da19099affb3\\\",\\\"moduleId\\\":\\\"21\\\",\\\"parentId\\\":\\\"1\\\",\\\"enCode\\\":\\\"SystemModule\\\",\\\"fullName\\\":\\\"系统功能\\\",\\\"icon\\\":\\\"fa fa-navicon\\\",\\\"urlAddress\\\":null,\\\"target\\\":\\\"iframe\\\",\\\"role\\\":6},{\\\"id\\\":\\\"6305ba01-d467-4246-936a-43d7254bd653\\\",\\\"moduleId\\\":\\\"80620d6f-55bd-492b-9c21-1b04ca268e75\\\",\\\"parentId\\\":\\\"16d4e2d5-d154-455f-94f7-63bf80ab26aa\\\",\\\"enCode\\\":\\\"Client_ChancePhase\\\",\\\"fullName\\\":\\\"商机阶段\\\",\\\"icon\\\":\\\"fa fa-tag\\\",\\\"urlAddress\\\":null,\\\"target\\\":\\\"iframe\\\",\\\"role\\\":6},{\\\"id\\\":\\\"6472bd18-1398-402a-ba89-ad0a5e15ce0b\\\",\\\"moduleId\\\":\\\"3b03806d-98d8-40fe-9895-01633119458c\\\",\\\"parentId\\\":\\\"16d4e2d5-d154-455f-94f7-63bf80ab26aa\\\",\\\"enCode\\\":\\\"Client_ProductInfo\\\",\\\"fullName\\\":\\\"产品信息\\\",\\\"icon\\\":\\\"fa fa-shopping-bag\\\",\\\"urlAddress\\\":null,\\\"target\\\":\\\"iframe\\\",\\\"role\\\":6},{\\\"id\\\":\\\"6704b301-4992-422e-86a4-782dd77c9c07\\\",\\\"moduleId\\\":\\\"0d296398-bc0e-4f38-996a-6e24bc88cc53\\\",\\\"parentId\\\":\\\"5\\\",\\\"enCode\\\":\\\"待办流程\\\",\\\"fullName\\\":\\\"待办流程\\\",\\\"icon\\\":\\\"fa fa-hourglass-half\\\",\\\"urlAddress\\\":null,\\\"target\\\":\\\"iframe\\\",\\\"role\\\":6},{\\\"id\\\":\\\"67daee29-034d-4672-961c-a96b08eabfab\\\",\\\"moduleId\\\":\\\"6a67a67f-ef07-41e7-baa5-00bc5f662a76\\\",\\\"parentId\\\":\\\"5\\\",\\\"enCode\\\":\\\"工作委托\\\",\\\"fullName\\\":\\\"工作委托\\\",\\\"icon\\\":\\\"fa fa-coffee\\\",\\\"urlAddress\\\":null,\\\"target\\\":\\\"iframe\\\",\\\"role\\\":6},{\\\"id\\\":\\\"723927c8-a663-43dc-b00d-e47aa9a4e633\\\",\\\"moduleId\\\":\\\"4\\\",\\\"parentId\\\":\\\"0\\\",\\\"enCode\\\":\\\"CommonInfo\\\",\\\"fullName\\\":\\\"邮件管理\\\",\\\"icon\\\":\\\"fa fa-globe\\\",\\\"urlAddress\\\":null,\\\"target\\\":\\\"expand\\\",\\\"role\\\":6},{\\\"id\\\":\\\"751b8022-0192-4397-a958-9883640b16f8\\\",\\\"moduleId\\\":\\\"a977d91e-77b7-4d60-a7ad-dfbc138f7c0a\\\",\\\"parentId\\\":\\\"b9f9df92-8ac5-46e2-90ac-68c5c2e034c3\\\",\\\"enCode\\\":\\\"企业号设置\\\",\\\"fullName\\\":\\\"企业号设置\\\",\\\"icon\\\":\\\"fa fa-plug\\\",\\\"urlAddress\\\":null,\\\"target\\\":\\\"iframe\\\",\\\"role\\\":6},{\\\"id\\\":\\\"775d6c10-624f-4a5a-bb9c-0cdb546a021c\\\",\\\"moduleId\\\":\\\"4d0f2e44-f68f-41fd-a55c-40ac67453ef4\\\",\\\"parentId\\\":\\\"b9f9df92-8ac5-46e2-90ac-68c5c2e034c3\\\",\\\"enCode\\\":\\\"企业号成员\\\",\\\"fullName\\\":\\\"企业号成员\\\",\\\"icon\\\":\\\"fa fa-users\\\",\\\"urlAddress\\\":null,\\\"target\\\":\\\"iframe\\\",\\\"role\\\":6},{\\\"id\\\":\\\"7bd108a2-9668-48f7-9e62-0e45f541eb95\\\",\\\"moduleId\\\":\\\"535d92e9-e066-406c-b2c2-697150a5bdff\\\",\\\"parentId\\\":\\\"ad147f6d-613f-4d2d-8c84-b749d0754f3b\\\",\\\"enCode\\\":\\\"ClienReceivable\\\",\\\"fullName\\\":\\\"收款管理\\\",\\\"icon\\\":\\\"fa fa-money\\\",\\\"urlAddress\\\":null,\\\"target\\\":\\\"iframe\\\",\\\"role\\\":6},{\\\"id\\\":\\\"801ecbce-57ac-4c42-9e02-687125b845a4\\\",\\\"moduleId\\\":\\\"04b88c96-8d99-45ec-956c-444efa630020\\\",\\\"parentId\\\":\\\"4\\\",\\\"enCode\\\":\\\"ResourceFileManage\\\",\\\"fullName\\\":\\\"文件资料\\\",\\\"icon\\\":\\\"fa fa-jsfiddle\\\",\\\"urlAddress\\\":null,\\\"target\\\":\\\"iframe\\\",\\\"role\\\":6},{\\\"id\\\":\\\"84179e23-339d-4bec-b7b6-d23402df3d7b\\\",\\\"moduleId\\\":\\\"b9f9df92-8ac5-46e2-90ac-68c5c2e034c3\\\",\\\"parentId\\\":\\\"0\\\",\\\"enCode\\\":\\\"WeChatManage\\\",\\\"fullName\\\":\\\"微信管理\\\",\\\"icon\\\":\\\"fa fa-weixin\\\",\\\"urlAddress\\\":null,\\\"target\\\":\\\"expand\\\",\\\"role\\\":6},{\\\"id\\\":\\\"850b4ff0-8dce-4eb1-9209-53f98946fd03\\\",\\\"moduleId\\\":\\\"16d4e2d5-d154-455f-94f7-63bf80ab26aa\\\",\\\"parentId\\\":\\\"ad147f6d-613f-4d2d-8c84-b749d0754f3b\\\",\\\"enCode\\\":\\\"ClientBaseData\\\",\\\"fullName\\\":\\\"基础设置\\\",\\\"icon\\\":\\\"fa fa fa-book\\\",\\\"urlAddress\\\":null,\\\"target\\\":\\\"expand\\\",\\\"role\\\":6},{\\\"id\\\":\\\"88c5c256-1fda-488d-b276-43a3fabc0bb5\\\",\\\"moduleId\\\":\\\"6be31cc9-4aee-4279-8435-4b266cec33f0\\\",\\\"parentId\\\":\\\"16d4e2d5-d154-455f-94f7-63bf80ab26aa\\\",\\\"enCode\\\":\\\"Client_Trade\\\",\\\"fullName\\\":\\\"客户行业\\\",\\\"icon\\\":\\\"fa fa-tag\\\",\\\"urlAddress\\\":null,\\\"target\\\":\\\"iframe\\\",\\\"role\\\":6},{\\\"id\\\":\\\"8ea5e2dd-c0bb-46c8-a4a4-0690862f212a\\\",\\\"moduleId\\\":\\\"b352f049-4331-4b19-ac22-e379cb30bd55\\\",\\\"parentId\\\":\\\"ad147f6d-613f-4d2d-8c84-b749d0754f3b\\\",\\\"enCode\\\":\\\"ClientOrder\\\",\\\"fullName\\\":\\\"客户订单\\\",\\\"icon\\\":\\\"fa fa-modx\\\",\\\"urlAddress\\\":null,\\\"target\\\":\\\"iframe\\\",\\\"role\\\":6},{\\\"id\\\":\\\"93a85232-59a7-4caf-a062-5f30d88f2818\\\",\\\"moduleId\\\":\\\"5\\\",\\\"parentId\\\":\\\"0\\\",\\\"enCode\\\":\\\"FlowManage\\\",\\\"fullName\\\":\\\"工作流程\\\",\\\"icon\\\":\\\"fa fa-share-alt\\\",\\\"urlAddress\\\":null,\\\"target\\\":\\\"expand\\\",\\\"role\\\":6},{\\\"id\\\":\\\"955d7bbe-2183-43b5-ba8c-46b58791bb7d\\\",\\\"moduleId\\\":\\\"ddce0dc1-3345-41b7-9716-22641fbbfaed\\\",\\\"parentId\\\":\\\"6\\\",\\\"enCode\\\":\\\"rpt001\\\",\\\"fullName\\\":\\\"销售日报表\\\",\\\"icon\\\":\\\"fa fa-pie-chart\\\",\\\"urlAddress\\\":null,\\\"target\\\":\\\"iframe\\\",\\\"role\\\":6},{\\\"id\\\":\\\"97f42cfd-4e11-4f78-9e78-4f639cdf9664\\\",\\\"moduleId\\\":\\\"5f1fa264-cc9b-4146-b49e-743e4633bb4c\\\",\\\"parentId\\\":\\\"ad147f6d-613f-4d2d-8c84-b749d0754f3b\\\",\\\"enCode\\\":\\\"ClientInvoice\\\",\\\"fullName\\\":\\\"客户开票\\\",\\\"icon\\\":\\\"fa fa-coffee\\\",\\\"urlAddress\\\":null,\\\"target\\\":\\\"iframe\\\",\\\"role\\\":6},{\\\"id\\\":\\\"9c95def0-670b-412f-9646-d3cda034fb5c\\\",\\\"moduleId\\\":\\\"affacee1-41a3-4c7b-8804-f1c1926babbd\\\",\\\"parentId\\\":\\\"6\\\",\\\"enCode\\\":\\\"PurchaseReport\\\",\\\"fullName\\\":\\\"采购报表\\\",\\\"icon\\\":\\\"fa fa-bar-chart\\\",\\\"urlAddress\\\":null,\\\"target\\\":\\\"iframe\\\",\\\"role\\\":6},{\\\"id\\\":\\\"9d61c2aa-3fb3-4b33-bdf1-6c95130d4aa4\\\",\\\"moduleId\\\":\\\"a653a69e-5dcc-4ece-b457-fc0875271a88\\\",\\\"parentId\\\":\\\"1\\\",\\\"enCode\\\":\\\"AppCreate\\\",\\\"fullName\\\":\\\"移动开发\\\",\\\"icon\\\":\\\"fa fa-file-code-o\\\",\\\"urlAddress\\\":null,\\\"target\\\":\\\"iframe\\\",\\\"role\\\":6},{\\\"id\\\":\\\"9f320a75-7ea8-4c5a-8f03-a6ff7f84726e\\\",\\\"moduleId\\\":\\\"c6b80ed5-b0cb-4844-ba1a-725d2cb4f935\\\",\\\"parentId\\\":\\\"4\\\",\\\"enCode\\\":\\\"EmailManage\\\",\\\"fullName\\\":\\\"邮件中心\\\",\\\"icon\\\":\\\"fa fa-send\\\",\\\"urlAddress\\\":null,\\\"target\\\":\\\"iframe\\\",\\\"role\\\":6},{\\\"id\\\":\\\"9f464765-bb5b-42ce-b918-b0429c45025f\\\",\\\"moduleId\\\":\\\"13\\\",\\\"parentId\\\":\\\"2\\\",\\\"enCode\\\":\\\"PostManage\\\",\\\"fullName\\\":\\\"岗位管理\\\",\\\"icon\\\":\\\"fa fa-graduation-cap\\\",\\\"urlAddress\\\":null,\\\"target\\\":\\\"iframe\\\",\\\"role\\\":6},{\\\"id\\\":\\\"9f5a31da-9b7f-4a00-9be5-c3a68f17ce44\\\",\\\"moduleId\\\":\\\"8\\\",\\\"parentId\\\":\\\"2\\\",\\\"enCode\\\":\\\"OrganizeManage\\\",\\\"fullName\\\":\\\"机构管理\\\",\\\"icon\\\":\\\"fa fa-sitemap\\\",\\\"urlAddress\\\":null,\\\"target\\\":\\\"iframe\\\",\\\"role\\\":6},{\\\"id\\\":\\\"a13dea7a-8055-44f6-8249-3a9b5c310c60\\\",\\\"moduleId\\\":\\\"901e6122-985d-4c84-8d8c-56560520f6ed\\\",\\\"parentId\\\":\\\"6\\\",\\\"enCode\\\":\\\"StorageReport\\\",\\\"fullName\\\":\\\"仓存报表\\\",\\\"icon\\\":\\\"fa fa-area-chart\\\",\\\"urlAddress\\\":null,\\\"target\\\":\\\"iframe\\\",\\\"role\\\":6},{\\\"id\\\":\\\"a79ac21a-296a-499d-8772-435993295bd0\\\",\\\"moduleId\\\":\\\"c30310a7-d0a5-4bf6-8655-c3834a8cc73d\\\",\\\"parentId\\\":\\\"16d4e2d5-d154-455f-94f7-63bf80ab26aa\\\",\\\"enCode\\\":\\\"Client_Sort\\\",\\\"fullName\\\":\\\"客户类别\\\",\\\"icon\\\":\\\"fa fa-tag\\\",\\\"urlAddress\\\":null,\\\"target\\\":\\\"iframe\\\",\\\"role\\\":6},{\\\"id\\\":\\\"ab078c2e-d3a4-439a-a4d0-e613680fd875\\\",\\\"moduleId\\\":\\\"e35d24ce-8a6a-46b9-8b3f-6dc864a8f342\\\",\\\"parentId\\\":\\\"4\\\",\\\"enCode\\\":\\\"NewManage\\\",\\\"fullName\\\":\\\"发件信息\\\",\\\"icon\\\":\\\"fa fa-feed\\\",\\\"urlAddress\\\":null,\\\"target\\\":\\\"iframe\\\",\\\"role\\\":6},{\\\"id\\\":\\\"ad1235c6-f119-4d33-b85b-441a379227fc\\\",\\\"moduleId\\\":\\\"c4d7ce1f-72de-4651-b495-6c466261e9af\\\",\\\"parentId\\\":\\\"7cec0a0f-7204-4240-b009-312fa0c11cbf\\\",\\\"enCode\\\":\\\"DataBaseBackup\\\",\\\"fullName\\\":\\\"数据库备份\\\",\\\"icon\\\":\\\"fa fa-cloud-download\\\",\\\"urlAddress\\\":null,\\\"target\\\":\\\"iframe\\\",\\\"role\\\":6},{\\\"id\\\":\\\"af86521f-0730-4725-a07f-afab430fbcf7\\\",\\\"moduleId\\\":\\\"7cec0a0f-7204-4240-b009-312fa0c11cbf\\\",\\\"parentId\\\":\\\"0\\\",\\\"enCode\\\":\\\"DatabaseManage\\\",\\\"fullName\\\":\\\"数据管理\\\",\\\"icon\\\":\\\"fa fa-database\\\",\\\"urlAddress\\\":null,\\\"target\\\":\\\"expand\\\",\\\"role\\\":6},{\\\"id\\\":\\\"b9b49bbd-a2eb-4ac3-a850-3da95800664e\\\",\\\"moduleId\\\":\\\"691f3810-a602-4523-8518-ce5856482d48\\\",\\\"parentId\\\":\\\"5\\\",\\\"enCode\\\":\\\"草稿流程\\\",\\\"fullName\\\":\\\"草稿流程\\\",\\\"icon\\\":\\\"fa fa-file-text-o\\\",\\\"urlAddress\\\":null,\\\"target\\\":\\\"iframe\\\",\\\"role\\\":6},{\\\"id\\\":\\\"bde4cc27-84ee-404b-97f9-d2850e88b172\\\",\\\"moduleId\\\":\\\"2\\\",\\\"parentId\\\":\\\"0\\\",\\\"enCode\\\":\\\"BaseManage\\\",\\\"fullName\\\":\\\"单位组织\\\",\\\"icon\\\":\\\"fa fa-coffee\\\",\\\"urlAddress\\\":null,\\\"target\\\":\\\"expand\\\",\\\"role\\\":6},{\\\"id\\\":\\\"cc13b9eb-1f54-42a7-95bf-809d1290dfa8\\\",\\\"moduleId\\\":\\\"be9cbe61-265f-4ddd-851e-d5a1cef6011b\\\",\\\"parentId\\\":\\\"16d4e2d5-d154-455f-94f7-63bf80ab26aa\\\",\\\"enCode\\\":\\\"Client_ChanceSource\\\",\\\"fullName\\\":\\\"商机来源\\\",\\\"icon\\\":\\\"fa fa-tag\\\",\\\"urlAddress\\\":null,\\\"target\\\":\\\"iframe\\\",\\\"role\\\":6},{\\\"id\\\":\\\"d6dacb0f-4336-43bb-ac9c-79d9ef8525ab\\\",\\\"moduleId\\\":\\\"b5cb98f6-fb41-4a0f-bc11-469ff117a411\\\",\\\"parentId\\\":\\\"5\\\",\\\"enCode\\\":\\\"FlowManage\\\",\\\"fullName\\\":\\\"流程管理\\\",\\\"icon\\\":\\\"fa fa-cogs\\\",\\\"urlAddress\\\":null,\\\"target\\\":\\\"expand\\\",\\\"role\\\":0},{\\\"id\\\":\\\"da37a697-03db-427c-a700-d229920055e0\\\",\\\"moduleId\\\":\\\"6\\\",\\\"parentId\\\":\\\"0\\\",\\\"enCode\\\":\\\"ReportManage\\\",\\\"fullName\\\":\\\"报表中心\\\",\\\"icon\\\":\\\"fa fa-area-chart\\\",\\\"urlAddress\\\":null,\\\"target\\\":\\\"expand\\\",\\\"role\\\":6},{\\\"id\\\":\\\"dce41a69-9315-461c-a9d5-92897c2dff00\\\",\\\"moduleId\\\":\\\"9db71a92-2ecb-496c-839f-7a82bc22905d\\\",\\\"parentId\\\":\\\"6\\\",\\\"enCode\\\":\\\"MoneyReport\\\",\\\"fullName\\\":\\\"对账报表\\\",\\\"icon\\\":\\\"fa fa-pie-chart\\\",\\\"urlAddress\\\":null,\\\"target\\\":\\\"iframe\\\",\\\"role\\\":6},{\\\"id\\\":\\\"de52574c-a579-4762-9fea-12ef1b459cd9\\\",\\\"moduleId\\\":\\\"923f7d65-e307-45f7-8f96-73ecbf23b324\\\",\\\"parentId\\\":\\\"5\\\",\\\"enCode\\\":\\\"已办流程\\\",\\\"fullName\\\":\\\"已办流程\\\",\\\"icon\\\":\\\"fa fa-flag\\\",\\\"urlAddress\\\":null,\\\"target\\\":\\\"iframe\\\",\\\"role\\\":6},{\\\"id\\\":\\\"e24ab610-b2f4-4c72-903e-5e6123415f8d\\\",\\\"moduleId\\\":\\\"021a59b0-2589-4f9e-8140-6052177a967c\\\",\\\"parentId\\\":\\\"5\\\",\\\"enCode\\\":\\\"我的流程\\\",\\\"fullName\\\":\\\"我的流程\\\",\\\"icon\\\":\\\"fa fa-file-word-o\\\",\\\"urlAddress\\\":null,\\\"target\\\":\\\"iframe\\\",\\\"role\\\":6},{\\\"id\\\":\\\"e33862df-a5ad-460e-ba14-23ca9f080089\\\",\\\"moduleId\\\":\\\"dec79ca7-3b54-432a-be1e-c96e7a2c7150\\\",\\\"parentId\\\":\\\"ad147f6d-613f-4d2d-8c84-b749d0754f3b\\\",\\\"enCode\\\":\\\"ClienCashBalanceReport\\\",\\\"fullName\\\":\\\"现金报表\\\",\\\"icon\\\":\\\"fa fa-bar-chart\\\",\\\"urlAddress\\\":null,\\\"target\\\":\\\"iframe\\\",\\\"role\\\":6},{\\\"id\\\":\\\"e7d4d7df-8045-42d0-b4cd-4166dd8fbe3d\\\",\\\"moduleId\\\":\\\"1b642904-d674-495f-a1e1-4814cc543870\\\",\\\"parentId\\\":\\\"5\\\",\\\"enCode\\\":\\\"发起流程\\\",\\\"fullName\\\":\\\"发起流程\\\",\\\"icon\\\":\\\"fa fa-edit\\\",\\\"urlAddress\\\":null,\\\"target\\\":\\\"\\\",\\\"role\\\":0},{\\\"id\\\":\\\"e80d0f04-a1b3-4037-8951-aaaf483ed8ea\\\",\\\"moduleId\\\":\\\"aed02ee7-322f-47f0-8ad6-ab0a2172628f\\\",\\\"parentId\\\":\\\"16d4e2d5-d154-455f-94f7-63bf80ab26aa\\\",\\\"enCode\\\":\\\"Client_Degree\\\",\\\"fullName\\\":\\\"客户程度\\\",\\\"icon\\\":\\\"fa fa-tag\\\",\\\"urlAddress\\\":null,\\\"target\\\":\\\"iframe\\\",\\\"role\\\":6},{\\\"id\\\":\\\"efb65c3e-f90d-42ea-8838-0631db262cb2\\\",\\\"moduleId\\\":\\\"27b6c487-a2d9-4a3a-a40d-dbba27a53d26\\\",\\\"parentId\\\":\\\"b5cb98f6-fb41-4a0f-bc11-469ff117a411\\\",\\\"enCode\\\":\\\"FlowMonitor\\\",\\\"fullName\\\":\\\"流程监控\\\",\\\"icon\\\":\\\"fa fa-eye\\\",\\\"urlAddress\\\":null,\\\"target\\\":\\\"iframe\\\",\\\"role\\\":6},{\\\"id\\\":\\\"f206cd07-0b7e-46ee-98b8-3e766e538e13\\\",\\\"moduleId\\\":\\\"11\\\",\\\"parentId\\\":\\\"2\\\",\\\"enCode\\\":\\\"RoleManage\\\",\\\"fullName\\\":\\\"角色管理\\\",\\\"icon\\\":\\\"fa fa-paw\\\",\\\"urlAddress\\\":null,\\\"target\\\":\\\"iframe\\\",\\\"role\\\":6},{\\\"id\\\":\\\"fa47f957-3980-4110-bb38-8a1bdd6fcfff\\\",\\\"moduleId\\\":\\\"a57993fa-5a94-44a8-a330-89196515c1d9\\\",\\\"parentId\\\":\\\"458113c6-b0be-4d6f-acce-7524f4bc3e88\\\",\\\"enCode\\\":\\\"FormDesign\\\",\\\"fullName\\\":\\\"表单设计\\\",\\\"icon\\\":\\\"fa fa-puzzle-piece\\\",\\\"urlAddress\\\":null,\\\"target\\\":\\\"iframe\\\",\\\"role\\\":6},{\\\"id\\\":\\\"fc86ded0-953e-4f90-bd66-0b069b2272d2\\\",\\\"moduleId\\\":\\\"458113c6-b0be-4d6f-acce-7524f4bc3e88\\\",\\\"parentId\\\":\\\"5\\\",\\\"enCode\\\":\\\"流程配置\\\",\\\"fullName\\\":\\\"流程配置\\\",\\\"icon\\\":\\\"fa fa-wrench\\\",\\\"urlAddress\\\":null,\\\"target\\\":\\\"expand\\\",\\\"role\\\":6},{\\\"id\\\":\\\"fd4838e0-c67c-4ea9-a40e-541a3abaebfc\\\",\\\"moduleId\\\":\\\"5cc9d2d9-e097-4b51-9b9e-84ca9f1a0ab5\\\",\\\"parentId\\\":\\\"b9f9df92-8ac5-46e2-90ac-68c5c2e034c3\\\",\\\"enCode\\\":\\\"企业号部门\\\",\\\"fullName\\\":\\\"企业号部门\\\",\\\"icon\\\":\\\"fa fa-sitemap\\\",\\\"urlAddress\\\":null,\\\"target\\\":\\\"iframe\\\",\\\"role\\\":6},{\\\"id\\\":\\\"fe6951df-72f0-40cf-96da-4b95d296d672\\\",\\\"moduleId\\\":\\\"34e362f4-c220-4fb7-b3f0-288c83417cb3\\\",\\\"parentId\\\":\\\"7cec0a0f-7204-4240-b009-312fa0c11cbf\\\",\\\"enCode\\\":\\\"DataBaseLink\\\",\\\"fullName\\\":\\\"数据库连接\\\",\\\"icon\\\":\\\"fa fa-plug\\\",\\\"urlAddress\\\":null,\\\"target\\\":\\\"iframe\\\",\\\"role\\\":6},{\\\"id\\\":\\\"18458a6b-bb9a-11ee-8286-00ff5021aaf8\\\",\\\"moduleId\\\":\\\"18458aab-bb9a-11ee-8286-00ff5021aaf8\\\",\\\"parentId\\\":\\\"1\\\",\\\"enCode\\\":\\\"MenuManage\\\",\\\"fullName\\\":\\\"菜单管理\\\",\\\"icon\\\":\\\"fa fa-desktop\\\",\\\"urlAddress\\\":\\\"/view/sys/page/menu/list\\\",\\\"target\\\":\\\"iframe\\\",\\\"role\\\":6}]";
        mv.addObject("menus", tempMenuStr);
        return mv;
    }

    @GetMapping("/default")
    public ModelAndView AdminIndex(){
        return new ModelAndView("default");
    }

    @GetMapping("/userInfo")
    public ModelAndView baseInfo(){
        return new ModelAndView("sys/userInfo");
    }

    public static void main(String[] args) {
        String temp = "[\n" +
                "  {\n" +
                "    \"F_ModuleId\": \"1\",\n" +
                "    \"F_ParentId\": \"0\",\n" +
                "    \"F_EnCode\": \"SysManage\",\n" +
                "    \"F_FullName\": \"系统管理\",\n" +
                "    \"F_Icon\": \"fa fa-desktop\",\n" +
                "    \"F_UrlAddress\": null,\n" +
                "    \"F_Target\": \"iframe\",\n" +
                "    \"F_Role\": 6\n" +
                "  },\n" +
                "  {\n" +
                "    \"F_ModuleId\": \"8\",\n" +
                "    \"F_ParentId\": \"2\",\n" +
                "    \"F_EnCode\": \"OrganizeManage\",\n" +
                "    \"F_FullName\": \"机构管理\",\n" +
                "    \"F_Icon\": \"fa fa-sitemap\",\n" +
                "    \"F_UrlAddress\": \"/BaseManage/Organize/Index\",\n" +
                "    \"F_Target\": \"iframe\",\n" +
                "    \"F_Role\": 6\n" +
                "  },\n" +
                "  {\n" +
                "    \"F_ModuleId\": \"7ae94059-9aa5-48eb-8330-4e2a6565b193\",\n" +
                "    \"F_ParentId\": \"1\",\n" +
                "    \"F_EnCode\": \"AreaManage\",\n" +
                "    \"F_FullName\": \"服务监控\",\n" +
                "    \"F_Icon\": \"fa fa-leaf\",\n" +
                "    \"F_UrlAddress\": \"/admin/host\",\n" +
                "    \"F_Target\": \"iframe\",\n" +
                "    \"F_Role\": 8\n" +
                "  },\n" +
                "  {\n" +
                "    \"F_ModuleId\": \"34e362f4-c220-4fb7-b3f0-288c83417cb3\",\n" +
                "    \"F_ParentId\": \"7cec0a0f-7204-4240-b009-312fa0c11cbf\",\n" +
                "    \"F_EnCode\": \"DataBaseLink\",\n" +
                "    \"F_FullName\": \"数据库连接\",\n" +
                "    \"F_Icon\": \"fa fa-plug\",\n" +
                "    \"F_UrlAddress\": \"/SystemManage/DataBaseLink/Index\",\n" +
                "    \"F_Target\": \"iframe\",\n" +
                "    \"F_Role\": 6\n" +
                "  },\n" +
                "  {\n" +
                "    \"F_ModuleId\": \"1b642904-d674-495f-a1e1-4814cc543870\",\n" +
                "    \"F_ParentId\": \"5\",\n" +
                "    \"F_EnCode\": \"发起流程\",\n" +
                "    \"F_FullName\": \"发起流程\",\n" +
                "    \"F_Icon\": \"fa fa-edit\",\n" +
                "    \"F_UrlAddress\": \"/FlowManage/FlowLaunch/Index\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"F_ModuleId\": \"a977d91e-77b7-4d60-a7ad-dfbc138f7c0a\",\n" +
                "    \"F_ParentId\": \"b9f9df92-8ac5-46e2-90ac-68c5c2e034c3\",\n" +
                "    \"F_EnCode\": \"企业号设置\",\n" +
                "    \"F_FullName\": \"企业号设置\",\n" +
                "    \"F_Icon\": \"fa fa-plug\",\n" +
                "    \"F_UrlAddress\": \"/WeChatManage/Token/Index\",\n" +
                "    \"F_Target\": \"iframe\",\n" +
                "    \"F_Role\": 6\n" +
                "  },\n" +
                "  {\n" +
                "    \"F_ModuleId\": \"00ae31cf-b340-4c17-9ee7-6dd08943df02\",\n" +
                "    \"F_ParentId\": \"458113c6-b0be-4d6f-acce-7524f4bc3e88\",\n" +
                "    \"F_EnCode\": \"FormCategory\",\n" +
                "    \"F_FullName\": \"表单类别\",\n" +
                "    \"F_Icon\": \"fa fa-tags\",\n" +
                "    \"F_UrlAddress\": \"/SystemManage/DataItemList/Index?ItemCode=FormSort\",\n" +
                "    \"F_Target\": \"iframe\",\n" +
                "    \"F_Role\": 6\n" +
                "  },\n" +
                "  {\n" +
                "    \"F_ModuleId\": \"16d4e2d5-d154-455f-94f7-63bf80ab26aa\",\n" +
                "    \"F_ParentId\": \"ad147f6d-613f-4d2d-8c84-b749d0754f3b\",\n" +
                "    \"F_EnCode\": \"ClientBaseData\",\n" +
                "    \"F_FullName\": \"基础设置\",\n" +
                "    \"F_Icon\": \"fa fa fa-book\",\n" +
                "    \"F_UrlAddress\": null,\n" +
                "    \"F_Target\": \"expand\",\n" +
                "    \"F_Role\": 6\n" +
                "  },\n" +
                "  {\n" +
                "    \"F_ModuleId\": \"92a535c9-4d4b-4500-968d-a142e671c09b\",\n" +
                "    \"F_ParentId\": \"6\",\n" +
                "    \"F_EnCode\": \"ReportTemp\",\n" +
                "    \"F_FullName\": \"报表管理\",\n" +
                "    \"F_Icon\": \"fa fa-cogs\",\n" +
                "    \"F_UrlAddress\": \"/ReportManage/Report/Index\",\n" +
                "    \"F_Target\": \"iframe\",\n" +
                "    \"F_Role\": 6\n" +
                "  },\n" +
                "  {\n" +
                "    \"F_ModuleId\": \"e35d24ce-8a6a-46b9-8b3f-6dc864a8f342\",\n" +
                "    \"F_ParentId\": \"4\",\n" +
                "    \"F_EnCode\": \"NewManage\",\n" +
                "    \"F_FullName\": \"发件信息\",\n" +
                "    \"F_Icon\": \"fa fa-feed\",\n" +
                "    \"F_UrlAddress\": \"/admin/mail\",\n" +
                "    \"F_Target\": \"iframe\",\n" +
                "    \"F_Role\": 6\n" +
                "  },\n" +
                "  {\n" +
                "    \"F_ModuleId\": \"3b03806d-98d8-40fe-9895-01633119458c\",\n" +
                "    \"F_ParentId\": \"16d4e2d5-d154-455f-94f7-63bf80ab26aa\",\n" +
                "    \"F_EnCode\": \"Client_ProductInfo\",\n" +
                "    \"F_FullName\": \"产品信息\",\n" +
                "    \"F_Icon\": \"fa fa-shopping-bag\",\n" +
                "    \"F_UrlAddress\": \"/SystemManage/DataItemList/Index?ItemCode=Client_ProductInfo\",\n" +
                "    \"F_Target\": \"iframe\",\n" +
                "    \"F_Role\": 6\n" +
                "  },\n" +
                "  {\n" +
                "    \"F_ModuleId\": \"27b6c487-a2d9-4a3a-a40d-dbba27a53d26\",\n" +
                "    \"F_ParentId\": \"b5cb98f6-fb41-4a0f-bc11-469ff117a411\",\n" +
                "    \"F_EnCode\": \"FlowMonitor\",\n" +
                "    \"F_FullName\": \"流程监控\",\n" +
                "    \"F_Icon\": \"fa fa-eye\",\n" +
                "    \"F_UrlAddress\": \"/FlowManage/FlowProcess/MonitoringIndex\",\n" +
                "    \"F_Target\": \"iframe\",\n" +
                "    \"F_Role\": 6\n" +
                "  },\n" +
                "  {\n" +
                "    \"F_ModuleId\": \"6252983c-52f5-402c-991b-ad19a9cb1f94\",\n" +
                "    \"F_ParentId\": \"4\",\n" +
                "    \"F_EnCode\": \"NoticeManage\",\n" +
                "    \"F_FullName\": \"发件数量\",\n" +
                "    \"F_Icon\": \"fa fa-volume-up\",\n" +
                "    \"F_UrlAddress\": \"/admin/mail/datecount\",\n" +
                "    \"F_Target\": \"iframe\",\n" +
                "    \"F_Role\": 6\n" +
                "  },\n" +
                "  {\n" +
                "    \"F_ModuleId\": \"66f6301c-1789-4525-a7d2-2b83272aafa6\",\n" +
                "    \"F_ParentId\": \"ad147f6d-613f-4d2d-8c84-b749d0754f3b\",\n" +
                "    \"F_EnCode\": \"ClientChance\",\n" +
                "    \"F_FullName\": \"商机管理\",\n" +
                "    \"F_Icon\": \"fa fa-binoculars\",\n" +
                "    \"F_UrlAddress\": \"/CustomerManage/Chance/Index\",\n" +
                "    \"F_Target\": \"iframe\",\n" +
                "    \"F_Role\": 6\n" +
                "  },\n" +
                "  {\n" +
                "    \"F_ModuleId\": \"affacee1-41a3-4c7b-8804-f1c1926babbd\",\n" +
                "    \"F_ParentId\": \"6\",\n" +
                "    \"F_EnCode\": \"PurchaseReport\",\n" +
                "    \"F_FullName\": \"采购报表\",\n" +
                "    \"F_Icon\": \"fa fa-bar-chart\",\n" +
                "    \"F_UrlAddress\": \"/ReportManage/ReportDemo/Purchase\",\n" +
                "    \"F_Target\": \"iframe\",\n" +
                "    \"F_Role\": 6\n" +
                "  },\n" +
                "  {\n" +
                "    \"F_ModuleId\": \"6be31cc9-4aee-4279-8435-4b266cec33f0\",\n" +
                "    \"F_ParentId\": \"16d4e2d5-d154-455f-94f7-63bf80ab26aa\",\n" +
                "    \"F_EnCode\": \"Client_Trade\",\n" +
                "    \"F_FullName\": \"客户行业\",\n" +
                "    \"F_Icon\": \"fa fa-tag\",\n" +
                "    \"F_UrlAddress\": \"/SystemManage/DataItemList/Index?ItemCode=Client_Trade\",\n" +
                "    \"F_Target\": \"iframe\",\n" +
                "    \"F_Role\": 6\n" +
                "  },\n" +
                "  {\n" +
                "    \"F_ModuleId\": \"5cc9d2d9-e097-4b51-9b9e-84ca9f1a0ab5\",\n" +
                "    \"F_ParentId\": \"b9f9df92-8ac5-46e2-90ac-68c5c2e034c3\",\n" +
                "    \"F_EnCode\": \"企业号部门\",\n" +
                "    \"F_FullName\": \"企业号部门\",\n" +
                "    \"F_Icon\": \"fa fa-sitemap\",\n" +
                "    \"F_UrlAddress\": \"/WeChatManage/Organize/Index\",\n" +
                "    \"F_Target\": \"iframe\",\n" +
                "    \"F_Role\": 6\n" +
                "  },\n" +
                "  {\n" +
                "    \"F_ModuleId\": \"08dfd779-92d5-4cd8-9982-a76176af0f7c\",\n" +
                "    \"F_ParentId\": \"458113c6-b0be-4d6f-acce-7524f4bc3e88\",\n" +
                "    \"F_EnCode\": \"FlowCategory\",\n" +
                "    \"F_FullName\": \"流程类别\",\n" +
                "    \"F_Icon\": \"fa fa-tags\",\n" +
                "    \"F_UrlAddress\": \"/SystemManage/DataItemList/Index?ItemCode=FlowSort\",\n" +
                "    \"F_Target\": \"iframe\",\n" +
                "    \"F_Role\": 6\n" +
                "  },\n" +
                "  {\n" +
                "    \"F_ModuleId\": \"c4d7ce1f-72de-4651-b495-6c466261e9af\",\n" +
                "    \"F_ParentId\": \"7cec0a0f-7204-4240-b009-312fa0c11cbf\",\n" +
                "    \"F_EnCode\": \"DataBaseBackup\",\n" +
                "    \"F_FullName\": \"数据库备份\",\n" +
                "    \"F_Icon\": \"fa fa-cloud-download\",\n" +
                "    \"F_UrlAddress\": \"/SystemManage/DataBaseBackup/Index\",\n" +
                "    \"F_Target\": \"iframe\",\n" +
                "    \"F_Role\": 6\n" +
                "  },\n" +
                "  {\n" +
                "    \"F_ModuleId\": \"691f3810-a602-4523-8518-ce5856482d48\",\n" +
                "    \"F_ParentId\": \"5\",\n" +
                "    \"F_EnCode\": \"草稿流程\",\n" +
                "    \"F_FullName\": \"草稿流程\",\n" +
                "    \"F_Icon\": \"fa fa-file-text-o\",\n" +
                "    \"F_UrlAddress\": \"/FlowManage/FlowRoughdraft/Index\",\n" +
                "    \"F_Target\": \"iframe\",\n" +
                "    \"F_Role\": 6\n" +
                "  },\n" +
                "  {\n" +
                "    \"F_ModuleId\": \"9\",\n" +
                "    \"F_ParentId\": \"2\",\n" +
                "    \"F_EnCode\": \"DepartmentManage\",\n" +
                "    \"F_FullName\": \"部门管理\",\n" +
                "    \"F_Icon\": \"fa fa-th-list\",\n" +
                "    \"F_UrlAddress\": \"/BaseManage/Department/Index\",\n" +
                "    \"F_Target\": \"iframe\",\n" +
                "    \"F_Role\": 6\n" +
                "  },\n" +
                "  {\n" +
                "    \"F_ModuleId\": \"2\",\n" +
                "    \"F_ParentId\": \"0\",\n" +
                "    \"F_EnCode\": \"BaseManage\",\n" +
                "    \"F_FullName\": \"单位组织\",\n" +
                "    \"F_Icon\": \"fa fa-coffee\",\n" +
                "    \"F_UrlAddress\": null,\n" +
                "    \"F_Target\": \"expand\",\n" +
                "    \"F_Role\": 6\n" +
                "  },\n" +
                "  {\n" +
                "    \"F_ModuleId\": \"4efd37bf-e3ef-4ced-8248-58eba046d78b\",\n" +
                "    \"F_ParentId\": \"1\",\n" +
                "    \"F_EnCode\": \"DataItemManage\",\n" +
                "    \"F_FullName\": \"测试数据\",\n" +
                "    \"F_Icon\": \"fa fa-book\",\n" +
                "    \"F_UrlAddress\": \"/home/lists\",\n" +
                "    \"F_Target\": \"iframe\",\n" +
                "    \"F_Role\": 6\n" +
                "  },\n" +
                "  {\n" +
                "    \"F_ModuleId\": \"5\",\n" +
                "    \"F_ParentId\": \"0\",\n" +
                "    \"F_EnCode\": \"FlowManage\",\n" +
                "    \"F_FullName\": \"工作流程\",\n" +
                "    \"F_Icon\": \"fa fa-share-alt\",\n" +
                "    \"F_UrlAddress\": null,\n" +
                "    \"F_Target\": \"expand\",\n" +
                "    \"F_Role\": 6\n" +
                "  },\n" +
                "  {\n" +
                "    \"F_ModuleId\": \"7adc5a16-54a4-408e-a101-2ddab8117d67\",\n" +
                "    \"F_ParentId\": \"1\",\n" +
                "    \"F_EnCode\": \"CodeRule\",\n" +
                "    \"F_FullName\": \"系统日志\",\n" +
                "    \"F_Icon\": \"fa fa-barcode\",\n" +
                "    \"F_UrlAddress\": \"/admin/System/syslog\",\n" +
                "    \"F_Target\": \"iframe\",\n" +
                "    \"F_Role\": 6\n" +
                "  },\n" +
                "  {\n" +
                "    \"F_ModuleId\": \"11\",\n" +
                "    \"F_ParentId\": \"2\",\n" +
                "    \"F_EnCode\": \"RoleManage\",\n" +
                "    \"F_FullName\": \"角色管理\",\n" +
                "    \"F_Icon\": \"fa fa-paw\",\n" +
                "    \"F_UrlAddress\": \"/BaseManage/Role/Index\",\n" +
                "    \"F_Target\": \"iframe\",\n" +
                "    \"F_Role\": 6\n" +
                "  },\n" +
                "  {\n" +
                "    \"F_ModuleId\": \"a57993fa-5a94-44a8-a330-89196515c1d9\",\n" +
                "    \"F_ParentId\": \"458113c6-b0be-4d6f-acce-7524f4bc3e88\",\n" +
                "    \"F_EnCode\": \"FormDesign\",\n" +
                "    \"F_FullName\": \"表单设计\",\n" +
                "    \"F_Icon\": \"fa fa-puzzle-piece\",\n" +
                "    \"F_UrlAddress\": \"/FlowManage/FormDesign/Index\",\n" +
                "    \"F_Target\": \"iframe\",\n" +
                "    \"F_Role\": 6\n" +
                "  },\n" +
                "  {\n" +
                "    \"F_ModuleId\": \"4d0f2e44-f68f-41fd-a55c-40ac67453ef4\",\n" +
                "    \"F_ParentId\": \"b9f9df92-8ac5-46e2-90ac-68c5c2e034c3\",\n" +
                "    \"F_EnCode\": \"企业号成员\",\n" +
                "    \"F_FullName\": \"企业号成员\",\n" +
                "    \"F_Icon\": \"fa fa-users\",\n" +
                "    \"F_UrlAddress\": \"/WeChatManage/User/Index\",\n" +
                "    \"F_Target\": \"iframe\",\n" +
                "    \"F_Role\": 6\n" +
                "  },\n" +
                "  {\n" +
                "    \"F_ModuleId\": \"c30310a7-d0a5-4bf6-8655-c3834a8cc73d\",\n" +
                "    \"F_ParentId\": \"16d4e2d5-d154-455f-94f7-63bf80ab26aa\",\n" +
                "    \"F_EnCode\": \"Client_Sort\",\n" +
                "    \"F_FullName\": \"客户类别\",\n" +
                "    \"F_Icon\": \"fa fa-tag\",\n" +
                "    \"F_UrlAddress\": \"/SystemManage/DataItemList/Index?ItemCode=Client_Sort\",\n" +
                "    \"F_Target\": \"iframe\",\n" +
                "    \"F_Role\": 6\n" +
                "  },\n" +
                "  {\n" +
                "    \"F_ModuleId\": \"ff1823b5-a966-4e6c-83de-807854f4f0fb\",\n" +
                "    \"F_ParentId\": \"6\",\n" +
                "    \"F_EnCode\": \"SalesReport\",\n" +
                "    \"F_FullName\": \"销售报表\",\n" +
                "    \"F_Icon\": \"fa fa-line-chart\",\n" +
                "    \"F_UrlAddress\": \"/ReportManage/ReportDemo/Sales\",\n" +
                "    \"F_Target\": \"iframe\",\n" +
                "    \"F_Role\": 6\n" +
                "  },\n" +
                "  {\n" +
                "    \"F_ModuleId\": \"021a59b0-2589-4f9e-8140-6052177a967c\",\n" +
                "    \"F_ParentId\": \"5\",\n" +
                "    \"F_EnCode\": \"我的流程\",\n" +
                "    \"F_FullName\": \"我的流程\",\n" +
                "    \"F_Icon\": \"fa fa-file-word-o\",\n" +
                "    \"F_UrlAddress\": \"/FlowManage/FlowMyProcess/Index\",\n" +
                "    \"F_Target\": \"iframe\",\n" +
                "    \"F_Role\": 6\n" +
                "  },\n" +
                "  {\n" +
                "    \"F_ModuleId\": \"1d3797f6-5cd2-41bc-b769-27f2513d61a9\",\n" +
                "    \"F_ParentId\": \"ad147f6d-613f-4d2d-8c84-b749d0754f3b\",\n" +
                "    \"F_EnCode\": \"ClientInfoManage\",\n" +
                "    \"F_FullName\": \"客户管理\",\n" +
                "    \"F_Icon\": \"fa fa-suitcase\",\n" +
                "    \"F_UrlAddress\": \"/CustomerManage/Customer/Index\",\n" +
                "    \"F_Target\": \"iframe\",\n" +
                "    \"F_Role\": 6\n" +
                "  },\n" +
                "  {\n" +
                "    \"F_ModuleId\": \"04b88c96-8d99-45ec-956c-444efa630020\",\n" +
                "    \"F_ParentId\": \"4\",\n" +
                "    \"F_EnCode\": \"ResourceFileManage\",\n" +
                "    \"F_FullName\": \"文件资料\",\n" +
                "    \"F_Icon\": \"fa fa-jsfiddle\",\n" +
                "    \"F_UrlAddress\": \"/PublicInfoManage/ResourceFile/Index\",\n" +
                "    \"F_Target\": \"iframe\",\n" +
                "    \"F_Role\": 6\n" +
                "  },\n" +
                "  {\n" +
                "    \"F_ModuleId\": \"2f820f6e-ae2e-472f-82cc-0129a2a57597\",\n" +
                "    \"F_ParentId\": \"7cec0a0f-7204-4240-b009-312fa0c11cbf\",\n" +
                "    \"F_EnCode\": \"DataBaseTable\",\n" +
                "    \"F_FullName\": \"数据表管理\",\n" +
                "    \"F_Icon\": \"fa fa-table\",\n" +
                "    \"F_UrlAddress\": \"/SystemManage/DataBaseTable/Index\",\n" +
                "    \"F_Target\": \"iframe\",\n" +
                "    \"F_Role\": 6\n" +
                "  },\n" +
                "  {\n" +
                "    \"F_ModuleId\": \"c0544bfd-a557-45fc-a856-a678a1e88bfc\",\n" +
                "    \"F_ParentId\": \"b5cb98f6-fb41-4a0f-bc11-469ff117a411\",\n" +
                "    \"F_EnCode\": \"FlowDelegate\",\n" +
                "    \"F_FullName\": \"流程指派\",\n" +
                "    \"F_Icon\": \"fa fa-random\",\n" +
                "    \"F_UrlAddress\": \"/FlowManage/FlowProcess/DesignationIndex\",\n" +
                "    \"F_Target\": \"iframe\",\n" +
                "    \"F_Role\": 6\n" +
                "  },\n" +
                "  {\n" +
                "    \"F_ModuleId\": \"901e6122-985d-4c84-8d8c-56560520f6ed\",\n" +
                "    \"F_ParentId\": \"6\",\n" +
                "    \"F_EnCode\": \"StorageReport\",\n" +
                "    \"F_FullName\": \"仓存报表\",\n" +
                "    \"F_Icon\": \"fa fa-area-chart\",\n" +
                "    \"F_UrlAddress\": \"/ReportManage/ReportDemo/Store\",\n" +
                "    \"F_Target\": \"iframe\",\n" +
                "    \"F_Role\": 6\n" +
                "  },\n" +
                "  {\n" +
                "    \"F_ModuleId\": \"aed02ee7-322f-47f0-8ad6-ab0a2172628f\",\n" +
                "    \"F_ParentId\": \"16d4e2d5-d154-455f-94f7-63bf80ab26aa\",\n" +
                "    \"F_EnCode\": \"Client_Degree\",\n" +
                "    \"F_FullName\": \"客户程度\",\n" +
                "    \"F_Icon\": \"fa fa-tag\",\n" +
                "    \"F_UrlAddress\": \"/SystemManage/DataItemList/Index?ItemCode=Client_Degree\",\n" +
                "    \"F_Target\": \"iframe\",\n" +
                "    \"F_Role\": 6\n" +
                "  },\n" +
                "  {\n" +
                "    \"F_ModuleId\": \"5f1fa264-cc9b-4146-b49e-743e4633bb4c\",\n" +
                "    \"F_ParentId\": \"ad147f6d-613f-4d2d-8c84-b749d0754f3b\",\n" +
                "    \"F_EnCode\": \"ClientInvoice\",\n" +
                "    \"F_FullName\": \"客户开票\",\n" +
                "    \"F_Icon\": \"fa fa-coffee\",\n" +
                "    \"F_UrlAddress\": \"/CustomerManage/Invoice/Index\",\n" +
                "    \"F_Target\": \"iframe\",\n" +
                "    \"F_Role\": 6\n" +
                "  },\n" +
                "  {\n" +
                "    \"F_ModuleId\": \"aa844d70-7211-41d9-907a-f9a10f4ac801\",\n" +
                "    \"F_ParentId\": \"b9f9df92-8ac5-46e2-90ac-68c5c2e034c3\",\n" +
                "    \"F_EnCode\": \"企业号应用\",\n" +
                "    \"F_FullName\": \"企业号应用\",\n" +
                "    \"F_Icon\": \"fa fa-safari\",\n" +
                "    \"F_UrlAddress\": \"/WeChatManage/App/Index\",\n" +
                "    \"F_Target\": \"iframe\",\n" +
                "    \"F_Role\": 6\n" +
                "  },\n" +
                "  {\n" +
                "    \"F_ModuleId\": \"f63a252b-975f-4832-a5be-1ce733bc8ece\",\n" +
                "    \"F_ParentId\": \"458113c6-b0be-4d6f-acce-7524f4bc3e88\",\n" +
                "    \"F_EnCode\": \"FlowDesign\",\n" +
                "    \"F_FullName\": \"流程设计\",\n" +
                "    \"F_Icon\": \"fa fa-share-alt\",\n" +
                "    \"F_UrlAddress\": \"/FlowManage/FlowDesign/Index\",\n" +
                "    \"F_Target\": \"iframe\",\n" +
                "    \"F_Role\": 6\n" +
                "  },\n" +
                "  {\n" +
                "    \"F_ModuleId\": \"0d296398-bc0e-4f38-996a-6e24bc88cc53\",\n" +
                "    \"F_ParentId\": \"5\",\n" +
                "    \"F_EnCode\": \"待办流程\",\n" +
                "    \"F_FullName\": \"待办流程\",\n" +
                "    \"F_Icon\": \"fa fa-hourglass-half\",\n" +
                "    \"F_UrlAddress\": \"/FlowManage/FlowBeforeProcessing/Index\",\n" +
                "    \"F_Target\": \"iframe\",\n" +
                "    \"F_Role\": 6\n" +
                "  },\n" +
                "  {\n" +
                "    \"F_ModuleId\": \"7cec0a0f-7204-4240-b009-312fa0c11cbf\",\n" +
                "    \"F_ParentId\": \"0\",\n" +
                "    \"F_EnCode\": \"DatabaseManage\",\n" +
                "    \"F_FullName\": \"数据管理\",\n" +
                "    \"F_Icon\": \"fa fa-database\",\n" +
                "    \"F_UrlAddress\": null,\n" +
                "    \"F_Target\": \"expand\",\n" +
                "    \"F_Role\": 6\n" +
                "  },\n" +
                "  {\n" +
                "    \"F_ModuleId\": \"6\",\n" +
                "    \"F_ParentId\": \"0\",\n" +
                "    \"F_EnCode\": \"ReportManage\",\n" +
                "    \"F_FullName\": \"报表中心\",\n" +
                "    \"F_Icon\": \"fa fa-area-chart\",\n" +
                "    \"F_UrlAddress\": null,\n" +
                "    \"F_Target\": \"expand\",\n" +
                "    \"F_Role\": 6\n" +
                "  },\n" +
                "  {\n" +
                "    \"F_ModuleId\": \"4\",\n" +
                "    \"F_ParentId\": \"0\",\n" +
                "    \"F_EnCode\": \"CommonInfo\",\n" +
                "    \"F_FullName\": \"邮件管理\",\n" +
                "    \"F_Icon\": \"fa fa-globe\",\n" +
                "    \"F_UrlAddress\": null,\n" +
                "    \"F_Target\": \"expand\",\n" +
                "    \"F_Role\": 6\n" +
                "  },\n" +
                "  {\n" +
                "    \"F_ModuleId\": \"13\",\n" +
                "    \"F_ParentId\": \"2\",\n" +
                "    \"F_EnCode\": \"PostManage\",\n" +
                "    \"F_FullName\": \"岗位管理\",\n" +
                "    \"F_Icon\": \"fa fa-graduation-cap\",\n" +
                "    \"F_UrlAddress\": \"/BaseManage/Post/Index\",\n" +
                "    \"F_Target\": \"iframe\",\n" +
                "    \"F_Role\": 6\n" +
                "  },\n" +
                "  {\n" +
                "    \"F_ModuleId\": \"923f7d65-e307-45f7-8f96-73ecbf23b324\",\n" +
                "    \"F_ParentId\": \"5\",\n" +
                "    \"F_EnCode\": \"已办流程\",\n" +
                "    \"F_FullName\": \"已办流程\",\n" +
                "    \"F_Icon\": \"fa fa-flag\",\n" +
                "    \"F_UrlAddress\": \"/FlowManage/FlowAferProcessing/Index\",\n" +
                "    \"F_Target\": \"iframe\",\n" +
                "    \"F_Role\": 6\n" +
                "  },\n" +
                "  {\n" +
                "    \"F_ModuleId\": \"52fe82f8-41ba-433e-9351-ef67e5b35217\",\n" +
                "    \"F_ParentId\": \"16d4e2d5-d154-455f-94f7-63bf80ab26aa\",\n" +
                "    \"F_EnCode\": \"Client_Level\",\n" +
                "    \"F_FullName\": \"客户级别\",\n" +
                "    \"F_Icon\": \"fa fa-tag\",\n" +
                "    \"F_UrlAddress\": \"/SystemManage/DataItemList/Index?ItemCode=Client_Level\",\n" +
                "    \"F_Target\": \"iframe\",\n" +
                "    \"F_Role\": 6\n" +
                "  },\n" +
                "  {\n" +
                "    \"F_ModuleId\": \"b352f049-4331-4b19-ac22-e379cb30bd55\",\n" +
                "    \"F_ParentId\": \"ad147f6d-613f-4d2d-8c84-b749d0754f3b\",\n" +
                "    \"F_EnCode\": \"ClientOrder\",\n" +
                "    \"F_FullName\": \"客户订单\",\n" +
                "    \"F_Icon\": \"fa fa-modx\",\n" +
                "    \"F_UrlAddress\": \"/CustomerManage/Order/Index\",\n" +
                "    \"F_Target\": \"iframe\",\n" +
                "    \"F_Role\": 6\n" +
                "  },\n" +
                "  {\n" +
                "    \"F_ModuleId\": \"b9f9df92-8ac5-46e2-90ac-68c5c2e034c3\",\n" +
                "    \"F_ParentId\": \"0\",\n" +
                "    \"F_EnCode\": \"WeChatManage\",\n" +
                "    \"F_FullName\": \"微信管理\",\n" +
                "    \"F_Icon\": \"fa fa-weixin\",\n" +
                "    \"F_UrlAddress\": null,\n" +
                "    \"F_Target\": \"expand\",\n" +
                "    \"F_Role\": 6\n" +
                "  },\n" +
                "  {\n" +
                "    \"F_ModuleId\": \"9db71a92-2ecb-496c-839f-7a82bc22905d\",\n" +
                "    \"F_ParentId\": \"6\",\n" +
                "    \"F_EnCode\": \"MoneyReport\",\n" +
                "    \"F_FullName\": \"对账报表\",\n" +
                "    \"F_Icon\": \"fa fa-pie-chart\",\n" +
                "    \"F_UrlAddress\": \"/ReportManage/ReportDemo/Reconciliation\",\n" +
                "    \"F_Target\": \"iframe\",\n" +
                "    \"F_Role\": 6\n" +
                "  },\n" +
                "  {\n" +
                "    \"F_ModuleId\": \"c6b80ed5-b0cb-4844-ba1a-725d2cb4f935\",\n" +
                "    \"F_ParentId\": \"4\",\n" +
                "    \"F_EnCode\": \"EmailManage\",\n" +
                "    \"F_FullName\": \"邮件中心\",\n" +
                "    \"F_Icon\": \"fa fa-send\",\n" +
                "    \"F_UrlAddress\": \"/PublicInfoManage/Email/Index\",\n" +
                "    \"F_Target\": \"iframe\",\n" +
                "    \"F_Role\": 6\n" +
                "  },\n" +
                "  {\n" +
                "    \"F_ModuleId\": \"23713d3a-810f-422d-acd5-39bec28ce47e\",\n" +
                "    \"F_ParentId\": \"4\",\n" +
                "    \"F_EnCode\": \"ScheduleManage\",\n" +
                "    \"F_FullName\": \"日程管理\",\n" +
                "    \"F_Icon\": \"fa fa-calendar\",\n" +
                "    \"F_UrlAddress\": \"/PublicInfoManage/Schedule/Index\",\n" +
                "    \"F_Target\": \"iframe\",\n" +
                "    \"F_Role\": 6\n" +
                "  },\n" +
                "  {\n" +
                "    \"F_ModuleId\": \"ad147f6d-613f-4d2d-8c84-b749d0754f3b\",\n" +
                "    \"F_ParentId\": \"0\",\n" +
                "    \"F_EnCode\": \"CustomerManage\",\n" +
                "    \"F_FullName\": \"客户关系\",\n" +
                "    \"F_Icon\": \"fa fa-briefcase\",\n" +
                "    \"F_UrlAddress\": null,\n" +
                "    \"F_Target\": \"expand\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"F_ModuleId\": \"be9cbe61-265f-4ddd-851e-d5a1cef6011b\",\n" +
                "    \"F_ParentId\": \"16d4e2d5-d154-455f-94f7-63bf80ab26aa\",\n" +
                "    \"F_EnCode\": \"Client_ChanceSource\",\n" +
                "    \"F_FullName\": \"商机来源\",\n" +
                "    \"F_Icon\": \"fa fa-tag\",\n" +
                "    \"F_UrlAddress\": \"/SystemManage/DataItemList/Index?ItemCode=Client_ChanceSource\",\n" +
                "    \"F_Target\": \"iframe\",\n" +
                "    \"F_Role\": 6\n" +
                "  },\n" +
                "  {\n" +
                "    \"F_ModuleId\": \"535d92e9-e066-406c-b2c2-697150a5bdff\",\n" +
                "    \"F_ParentId\": \"ad147f6d-613f-4d2d-8c84-b749d0754f3b\",\n" +
                "    \"F_EnCode\": \"ClienReceivable\",\n" +
                "    \"F_FullName\": \"收款管理\",\n" +
                "    \"F_Icon\": \"fa fa-money\",\n" +
                "    \"F_UrlAddress\": \"/CustomerManage/Receivable/Index\",\n" +
                "    \"F_Target\": \"iframe\",\n" +
                "    \"F_Role\": 6\n" +
                "  },\n" +
                "  {\n" +
                "    \"F_ModuleId\": \"6a67a67f-ef07-41e7-baa5-00bc5f662a76\",\n" +
                "    \"F_ParentId\": \"5\",\n" +
                "    \"F_EnCode\": \"工作委托\",\n" +
                "    \"F_FullName\": \"工作委托\",\n" +
                "    \"F_Icon\": \"fa fa-coffee\",\n" +
                "    \"F_UrlAddress\": \"/FlowManage/FlowDelegate/Index\",\n" +
                "    \"F_Target\": \"iframe\",\n" +
                "    \"F_Role\": 6\n" +
                "  },\n" +
                "  {\n" +
                "    \"F_ModuleId\": \"12\",\n" +
                "    \"F_ParentId\": \"2\",\n" +
                "    \"F_EnCode\": \"JobManage\",\n" +
                "    \"F_FullName\": \"职位管理\",\n" +
                "    \"F_Icon\": \"fa fa-briefcase\",\n" +
                "    \"F_UrlAddress\": \"/BaseManage/Job/Index\",\n" +
                "    \"F_Target\": \"iframe\",\n" +
                "    \"F_Role\": 6\n" +
                "  },\n" +
                "  {\n" +
                "    \"F_ModuleId\": \"f21fa3a0-c523-4d02-99ca-fd8dd3ae3d59\",\n" +
                "    \"F_ParentId\": \"1\",\n" +
                "    \"F_EnCode\": \"SystemLog\",\n" +
                "    \"F_FullName\": \"系统日志\",\n" +
                "    \"F_Icon\": \"fa fa-warning\",\n" +
                "    \"F_UrlAddress\": \"/SystemManage/Log/Index\",\n" +
                "    \"F_Target\": \"iframe\",\n" +
                "    \"F_Role\": 6\n" +
                "  },\n" +
                "  {\n" +
                "    \"F_ModuleId\": \"14\",\n" +
                "    \"F_ParentId\": \"2\",\n" +
                "    \"F_EnCode\": \"UserGroupManage\",\n" +
                "    \"F_FullName\": \"用户组管理\",\n" +
                "    \"F_Icon\": \"fa fa-group\",\n" +
                "    \"F_UrlAddress\": \"/BaseManage/UserGroup/Index\",\n" +
                "    \"F_Target\": \"iframe\",\n" +
                "    \"F_Role\": 6\n" +
                "  },\n" +
                "  {\n" +
                "    \"F_ModuleId\": \"21\",\n" +
                "    \"F_ParentId\": \"1\",\n" +
                "    \"F_EnCode\": \"SystemModule\",\n" +
                "    \"F_FullName\": \"系统功能\",\n" +
                "    \"F_Icon\": \"fa fa-navicon\",\n" +
                "    \"F_UrlAddress\": \"/AuthorizeManage/Module/Index\",\n" +
                "    \"F_Target\": \"iframe\",\n" +
                "    \"F_Role\": 6\n" +
                "  },\n" +
                "  {\n" +
                "    \"F_ModuleId\": \"1ef31fba-7f0a-46f7-b533-49dd0c2e51e0\",\n" +
                "    \"F_ParentId\": \"ad147f6d-613f-4d2d-8c84-b749d0754f3b\",\n" +
                "    \"F_EnCode\": \"ClienReceivableReport\",\n" +
                "    \"F_FullName\": \"收款报表\",\n" +
                "    \"F_Icon\": \"fa fa-bar-chart\",\n" +
                "    \"F_UrlAddress\": \"/CustomerManage/ReceivableReport/Index\",\n" +
                "    \"F_Target\": \"iframe\",\n" +
                "    \"F_Role\": 6\n" +
                "  },\n" +
                "  {\n" +
                "    \"F_ModuleId\": \"80620d6f-55bd-492b-9c21-1b04ca268e75\",\n" +
                "    \"F_ParentId\": \"16d4e2d5-d154-455f-94f7-63bf80ab26aa\",\n" +
                "    \"F_EnCode\": \"Client_ChancePhase\",\n" +
                "    \"F_FullName\": \"商机阶段\",\n" +
                "    \"F_Icon\": \"fa fa-tag\",\n" +
                "    \"F_UrlAddress\": \"/SystemManage/DataItemList/Index?ItemCode=Client_ChancePhase\",\n" +
                "    \"F_Target\": \"iframe\",\n" +
                "    \"F_Role\": 6\n" +
                "  },\n" +
                "  {\n" +
                "    \"F_ModuleId\": \"458113c6-b0be-4d6f-acce-7524f4bc3e88\",\n" +
                "    \"F_ParentId\": \"5\",\n" +
                "    \"F_EnCode\": \"流程配置\",\n" +
                "    \"F_FullName\": \"流程配置\",\n" +
                "    \"F_Icon\": \"fa fa-wrench\",\n" +
                "    \"F_UrlAddress\": null,\n" +
                "    \"F_Target\": \"expand\",\n" +
                "    \"F_Role\": 6\n" +
                "  },\n" +
                "  {\n" +
                "    \"F_ModuleId\": \"b0261df5-7be0-4c8e-829c-15836e200af0\",\n" +
                "    \"F_ParentId\": \"1\",\n" +
                "    \"F_EnCode\": \"SystemForm\",\n" +
                "    \"F_FullName\": \"系统表单\",\n" +
                "    \"F_Icon\": \"fa fa-paw\",\n" +
                "    \"F_UrlAddress\": \"/AuthorizeManage/ModuleForm/Index\",\n" +
                "    \"F_Target\": \"iframe\",\n" +
                "    \"F_Role\": 6\n" +
                "  },\n" +
                "  {\n" +
                "    \"F_ModuleId\": \"9fc384f5-efb7-439e-9fe1-3e50807e6399\",\n" +
                "    \"F_ParentId\": \"ad147f6d-613f-4d2d-8c84-b749d0754f3b\",\n" +
                "    \"F_EnCode\": \"ClienExpenses\",\n" +
                "    \"F_FullName\": \"支出管理\",\n" +
                "    \"F_Icon\": \"fa fa-credit-card-alt\",\n" +
                "    \"F_UrlAddress\": \"/CustomerManage/Expenses/Index\",\n" +
                "    \"F_Target\": \"iframe\",\n" +
                "    \"F_Role\": 6\n" +
                "  },\n" +
                "  {\n" +
                "    \"F_ModuleId\": \"77f13de5-32ad-4226-9e24-f1db507e78cb\",\n" +
                "    \"F_ParentId\": \"16d4e2d5-d154-455f-94f7-63bf80ab26aa\",\n" +
                "    \"F_EnCode\": \"Client_PaymentMode\",\n" +
                "    \"F_FullName\": \"收支方式\",\n" +
                "    \"F_Icon\": \"fa fa-tag\",\n" +
                "    \"F_UrlAddress\": \"/SystemManage/DataItemList/Index?ItemCode=Client_PaymentMode\",\n" +
                "    \"F_Target\": \"iframe\",\n" +
                "    \"F_Role\": 6\n" +
                "  },\n" +
                "  {\n" +
                "    \"F_ModuleId\": \"b5cb98f6-fb41-4a0f-bc11-469ff117a411\",\n" +
                "    \"F_ParentId\": \"5\",\n" +
                "    \"F_EnCode\": \"FlowManage\",\n" +
                "    \"F_FullName\": \"流程管理\",\n" +
                "    \"F_Icon\": \"fa fa-cogs\",\n" +
                "    \"F_UrlAddress\": null,\n" +
                "    \"F_Target\": \"expand\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"F_ModuleId\": \"cfa631fe-e7f8-42b5-911f-7172f178a811\",\n" +
                "    \"F_ParentId\": \"1\",\n" +
                "    \"F_EnCode\": \"CodeCreate\",\n" +
                "    \"F_FullName\": \"快速开发\",\n" +
                "    \"F_Icon\": \"fa fa-code\",\n" +
                "    \"F_UrlAddress\": \"/GeneratorManage/Template/Index\",\n" +
                "    \"F_Target\": \"iframe\",\n" +
                "    \"F_Role\": 6\n" +
                "  },\n" +
                "  {\n" +
                "    \"F_ModuleId\": \"10\",\n" +
                "    \"F_ParentId\": \"2\",\n" +
                "    \"F_EnCode\": \"UserManage\",\n" +
                "    \"F_FullName\": \"用户管理\",\n" +
                "    \"F_Icon\": \"fa fa-user\",\n" +
                "    \"F_UrlAddress\": \"/BaseManage/User/Index\",\n" +
                "    \"F_Target\": \"iframe\",\n" +
                "    \"F_Role\": 6\n" +
                "  },\n" +
                "  {\n" +
                "    \"F_ModuleId\": \"a653a69e-5dcc-4ece-b457-fc0875271a88\",\n" +
                "    \"F_ParentId\": \"1\",\n" +
                "    \"F_EnCode\": \"AppCreate\",\n" +
                "    \"F_FullName\": \"移动开发\",\n" +
                "    \"F_Icon\": \"fa fa-file-code-o\",\n" +
                "    \"F_UrlAddress\": \"/AppManage/AppProjects/Index\",\n" +
                "    \"F_Target\": \"iframe\",\n" +
                "    \"F_Role\": 6\n" +
                "  },\n" +
                "  {\n" +
                "    \"F_ModuleId\": \"dec79ca7-3b54-432a-be1e-c96e7a2c7150\",\n" +
                "    \"F_ParentId\": \"ad147f6d-613f-4d2d-8c84-b749d0754f3b\",\n" +
                "    \"F_EnCode\": \"ClienCashBalanceReport\",\n" +
                "    \"F_FullName\": \"现金报表\",\n" +
                "    \"F_Icon\": \"fa fa-bar-chart\",\n" +
                "    \"F_UrlAddress\": \"/CustomerManage/CashBalanceReport/Index\",\n" +
                "    \"F_Target\": \"iframe\",\n" +
                "    \"F_Role\": 6\n" +
                "  },\n" +
                "  {\n" +
                "    \"F_ModuleId\": \"ddce0dc1-3345-41b7-9716-22641fbbfaed\",\n" +
                "    \"F_ParentId\": \"6\",\n" +
                "    \"F_EnCode\": \"rpt001\",\n" +
                "    \"F_FullName\": \"销售日报表\",\n" +
                "    \"F_Icon\": \"fa fa-pie-chart\",\n" +
                "    \"F_UrlAddress\": \"/ReportManage/Report/ReportPreview?keyValue=a9762855-cd45-4815-a8e1-c8b818f79ad5\",\n" +
                "    \"F_Target\": \"iframe\",\n" +
                "    \"F_Role\": 6\n" +
                "  },\n" +
                "  {\n" +
                "    \"F_ModuleId\": \"62af0605-4558-47b1-9530-bc3515036b37\",\n" +
                "    \"F_ParentId\": \"16d4e2d5-d154-455f-94f7-63bf80ab26aa\",\n" +
                "    \"F_EnCode\": \"Client_PaymentAccount\",\n" +
                "    \"F_FullName\": \"收支账户\",\n" +
                "    \"F_Icon\": \"fa fa-tag\",\n" +
                "    \"F_UrlAddress\": \"/SystemManage/DataItemList/Index?ItemCode=Client_PaymentAccount\",\n" +
                "    \"F_Target\": \"iframe\",\n" +
                "    \"F_Role\": 6\n" +
                "  },\n" +
                "  {\n" +
                "    \"F_ModuleId\": \"eab4a37f-d976-42b7-9589-489ed0678151\",\n" +
                "    \"F_ParentId\": \"16d4e2d5-d154-455f-94f7-63bf80ab26aa\",\n" +
                "    \"F_EnCode\": \"Client_ExpensesType\",\n" +
                "    \"F_FullName\": \"支出种类\",\n" +
                "    \"F_Icon\": \"fa fa-tag\",\n" +
                "    \"F_UrlAddress\": \"/SystemManage/DataItemList/Index?ItemCode=Client_ExpensesType\",\n" +
                "    \"F_Target\": \"iframe\",\n" +
                "    \"F_Role\": 6\n" +
                "  }\n" +
                "]\n";
        List<JSONObject> jsonObjects = JSON.parseArray(temp).toJavaList(JSONObject.class);
        jsonObjects.forEach(item -> {
            item.put("id", UUID.randomUUID());
        });
        System.out.println(jsonObjects);
    }
}
