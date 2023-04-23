package com.irojascorsico.websecurity.Auth;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AuthResponse {

    String token;

    public Object orElObject(Object object)
    {return null;
    }
    
}
