package org.mn.msaccount.client.msproduct;

import java.util.List;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "ms-product", url = "${api.ms-product.url}",
        configuration = MsProductClientFeignConfig.class)
public interface MsProductClient {

    @GetMapping("/orders/by-user-id")
    List<OrderResponseDto> getOrdersByUserId(@RequestParam Long userId);


}
