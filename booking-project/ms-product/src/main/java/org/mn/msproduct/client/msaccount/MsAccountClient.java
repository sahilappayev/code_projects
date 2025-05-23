package org.mn.msproduct.client.msaccount;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "ms-account", url = "${api.ms-account.url}",
        configuration = MsAccountClientFeignConfig.class)
public interface MsAccountClient {

    @GetMapping("/users/{id}")
    UserResponseDto getUserById(@PathVariable Long id);

}
