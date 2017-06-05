/*
 * 文件名称：${modelName}.java
 */
package ${pakageName};

import javax.persistence.Table;
import javax.persistence.Column;
import com.gitile.core.bean.BaseEntity;
${improtField!''}

/**
 * 名称：${modelCaption!''}
 * 模块描述：数据库表对应实体类
 * 作者：系统自动生成
 */
 @Table(name="${tableName}")
public class ${modelName} extends BaseEntity {

	/**构造函数**/
${strutField!''}
	/**属性**/
${nameField!''}
	/**属性Get、Set函数**/
${getSetField!''}
}