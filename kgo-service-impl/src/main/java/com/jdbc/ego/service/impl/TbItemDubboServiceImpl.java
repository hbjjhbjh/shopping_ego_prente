package com.jdbc.ego.service.impl;

import com.ego.commons.pojo.EasyUIDataGrid;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jdbc.ego.mapper.TbItemDescMapper;
import com.jdbc.ego.mapper.TbItemMapper;
import com.jdbc.ego.pojo.TbItem;
import com.jdbc.ego.pojo.TbItemDesc;
import com.jdbc.ego.pojo.TbItemExample;
import com.kgo.dubbo.service.TbItemDubboService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class TbItemDubboServiceImpl implements TbItemDubboService {
    //��Ʒ��Ϣ
    @Resource
    private TbItemMapper tbItemMapper;
    //��Ʒ������
    @Resource
    private TbItemDescMapper tbItemDescMapper;

    /*
     * ������Ʒ��Ϣ���߼�ɾ����
     * */
    @Override
    public int insertItemAndItemDesc(TbItem item, TbItemDesc desc) throws Exception {
        int index = 0;
        try {
            index = tbItemMapper.insertSelective(item);
            index +=tbItemDescMapper.insertSelective(desc);
        }catch (Exception e){
            e.printStackTrace();
        }
        if (index == 2){
            return 1;
        }else {
            throw new Exception("��Ʒ����ʧ�ܣ����ݻ�ԭ");
        }
    }

    /*
     * ɾ����Ʒ��Ϣ���߼�ɾ����
     * */
    public int updateTbItem(TbItem tbItem) {
        return tbItemMapper.updateByPrimaryKeySelective(tbItem);
    }

    /*
     * ��ʾ��Ʒ��Ϣ
     * */
    public EasyUIDataGrid showByProvider(int page, int rows) {
        System.out.println("66666");
        PageHelper.startPage(page, rows);
        TbItemExample example = new TbItemExample();
        //�����ݿ��в�ѯ������
        List<TbItem> list = tbItemMapper.selectByExample(example);
        PageInfo<TbItem> pi = new PageInfo(list);
        EasyUIDataGrid dg = new EasyUIDataGrid();
        dg.setRows(pi.getList());
        dg.setTotal(pi.getTotal());
        System.out.println("77777777");
        return dg;
    }
}
