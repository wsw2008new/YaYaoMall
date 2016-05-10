package com.yayao.service.impl.test;

import static org.junit.Assert.*;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;

import com.yayao.bean.MerCategory;
import com.yayao.bean.MerSeller;
import com.yayao.bean.UserLevel;
import com.yayao.service.MerCategoryService;
import com.yayao.service.MerSellerService;
import com.yayao.service.UserLevelService;
@SuppressWarnings("deprecation")
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:config/applicationContext.xml"})
@TransactionConfiguration(transactionManager="txManager",defaultRollback = false)//true:始终回滚 false:数据提交
public class MerCategoryServiceImplTest {
	@Autowired
	@Qualifier("merCategoryService")
	MerCategoryService merCategoryService;
	@Autowired
	@Qualifier("merSellerService")
	MerSellerService merSellerService;
	@Autowired
	@Qualifier("sessionFactory")
	SessionFactory sessionFactory;
	Session session;
	@Before
	public void setUp() throws Exception {
		//session=sessionFactory.openSession();
		session=sessionFactory.openSession();
		System.out.println(session);
	}
	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testAddMerCategory() {
		MerCategory ul=new MerCategory();
		ul.setCateName("青2茶");
		MerSeller merSeller = merSellerService.loadMerSeller(6);
		ul.setMerSeller(merSeller);
		merCategoryService.addMerCategory(ul);
	}

	@Test
	public void testUpdateMerCategory() {
		List<MerCategory> mc = merCategoryService.browseMerCategory(1);
		for (int i = 0; i < mc.size(); i++) {
			MerCategory merCategory = mc.get(i);
			merCategory.setMerSeller(merSellerService.loadMerSeller(1));
			merCategoryService.updateMerCategory(merCategory);
		}
	}

	@Test
	public void testDelMerCategory() {
		//MerCategory merCategory = merCategoryService.loadMerCategory(6, "红茶");
		//merCategory.setCateName("红茶");
		//MerSeller merSeller = merSellerService.loadMerSeller(5);
		//MerSeller merSeller = new MerSeller();
		//merSeller.setMersellerid(4);
		//merCategory.setMerSeller(merSeller);
		//merCategory.setMercategoryid(5);
		//merCategoryService.updateMerCategory(merCategory);
		merCategoryService.delMerCategory(36);
	}

	@Test
	public void testBrowseMerCategory() {
		List<MerCategory> list = merCategoryService.browseMerCategory(1);
		for (int i = 0; i < list.size(); i++) {
			
			System.out.println(list.get(i));
			System.out.println(list.get(i).getMercategoryid());
			System.out.println(list.get(i).getCateName());
			System.out.println(list.get(i).getCateDate());
		}
	}

	@Test
	public void testLoadMerCategory() {
		MerCategory mercate = merCategoryService.loadMerCategory(1,"黑茶");
	System.out.println(mercate.getCateDate());
	}

	@Test
	public void testChkMerCategory() {
		fail("Not yet implemented");
	}

}
