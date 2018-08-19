package com.itao.portal.integration;

import com.itao.common.result.ActionResult;
import com.itao.common.utils.JsonUtils;
import com.itao.integration.shard.dto.QueryItemDescResDTO;
import com.itao.integration.shard.dto.QueryItemParamItemResDTO;
import com.itao.integration.shard.dto.QueryItemReqDTO;
import com.itao.integration.shard.dto.QueryItemResDTO;
import com.itao.integration.shard.item.ItemAPI;
import com.itao.portal.pojo.ItemBaseInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
public class ItemIntegration {

    private static final Logger logger = LoggerFactory.getLogger(ItemIntegration.class);

    @Autowired
    ItemAPI itemAPI;

    public ItemBaseInfo getItemInfo(Long itemId) {
        logger.info("调用integration查询商品基础信息开始，参数： {}", itemId);
        ItemBaseInfo itemBaseInfo = null;
        try {
            QueryItemReqDTO queryItemReqDTO = new QueryItemReqDTO();
            queryItemReqDTO.setItemId(itemId);
            ActionResult<QueryItemResDTO> actionResult = itemAPI.getItemBaseInfo(queryItemReqDTO);
            if (!actionResult.isResult()) {
                logger.info("调用integration失败，错误消息：{}", actionResult.getErrorMsg());
                throw new RuntimeException(actionResult.getErrorMsg());
            }
            QueryItemResDTO itemResDTO = actionResult.getData();
            itemBaseInfo = new ItemBaseInfo();
            BeanUtils.copyProperties(itemResDTO, itemBaseInfo);

        } catch (Exception e) {
            logger.info("调用integration异常，错误消息：{}", e);
        }
        return itemBaseInfo;
    }

    public String getItemDesc(Long itemId) {
        logger.info("调用integration查询商品描述信息开始，参数： {}", itemId);
        String itemDesc = "";
        try {
            QueryItemReqDTO queryItemReqDTO = new QueryItemReqDTO();
            queryItemReqDTO.setItemId(itemId);
            ActionResult<QueryItemDescResDTO> actionResult = itemAPI.getItemDesc(queryItemReqDTO);
            if (!actionResult.isResult()) {
                logger.info("调用integration失败，错误消息：{}", actionResult.getErrorMsg());
                throw new RuntimeException(actionResult.getErrorMsg());
            }
            itemDesc = actionResult.getData().getItemDesc();

        } catch (Exception e) {
            logger.info("调用integration异常，错误消息：{}", e);
        }
        return itemDesc;
    }

    public String getItemParamItem(Long itemId) {
        logger.info("调用integration查询商品规格参数信息开始，参数： {}", itemId);
        try {
            QueryItemReqDTO queryItemReqDTO = new QueryItemReqDTO();
            queryItemReqDTO.setItemId(itemId);
            ActionResult<QueryItemParamItemResDTO> actionResult = itemAPI.getItemParamItem(queryItemReqDTO);
            if (!actionResult.isResult()) {
                logger.info("调用integration失败，错误消息：{}", actionResult.getErrorMsg());
                throw new RuntimeException(actionResult.getErrorMsg());
            }
            String paramData = actionResult.getData().getParamData();
            // 生成html
            // 把规格参数json数据转换成java对象
            List<Map> jsonList = JsonUtils.jsonToList(paramData, Map.class);
            StringBuffer sb = new StringBuffer();
            sb.append("<table cellpadding=\"0\" cellspacing=\"1\" width=\"100%\" border=\"0\" class=\"Ptable\">\n");
            sb.append("    <tbody>\n");
            for (Map m1 : jsonList) {
                sb.append("        <tr>\n");
                sb.append("            <th class=\"tdTitle\" colspan=\"2\">" + m1.get("group") + "</th>\n");
                sb.append("        </tr>\n");
                List<Map> list2 = (List<Map>) m1.get("params");
                for (Map m2 : list2) {
                    sb.append("        <tr>\n");
                    sb.append("            <td class=\"tdTitle\">" + m2.get("k") + "</td>\n");
                    sb.append("            <td>" + m2.get("v") + "</td>\n");
                    sb.append("        </tr>\n");
                }
            }
            sb.append("    </tbody>\n");
            sb.append("</table>");
            // 返回html片段
            return sb.toString();

        } catch (Exception e) {
            logger.info("调用integration异常，错误消息：{}", e);
        }
        return "";

    }

}
