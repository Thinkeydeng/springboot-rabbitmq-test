package com.tk.message;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 测试消息体
 *
 * @author yangkai.shen
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MessageStruct implements Serializable {
	private static final long serialVersionUID = 392365881428311040L;

	private String message;
}
