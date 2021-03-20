#import "LogDepthBuffer/ShaderLib/LogDepthBuffer.glsllib"
#if defined(HAS_GLOWMAP) || defined(HAS_COLORMAP) || (defined(HAS_LIGHTMAP) && !defined(SEPARATE_TEXCOORD))
    #define NEED_TEXCOORD1
#endif

uniform vec4 m_Color;
uniform sampler2D m_ColorMap;
uniform sampler2D m_LightMap;

varying vec2 texCoord1;
varying vec2 texCoord2;

varying vec4 vertColor;

#ifdef LOGARITHIMIC_DEPTH_BUFFER
  uniform vec2 g_FrustumNearFar;
  varying vec4 positionProjectionSpace;
#endif

void main(){
    vec4 color = vec4(1.0);

    #ifdef HAS_COLORMAP
        color *= texture2D(m_ColorMap, texCoord1);
    #endif

    #ifdef HAS_VERTEXCOLOR
        color *= vertColor;
    #endif

    #ifdef HAS_COLOR
        color *= m_Color;
    #endif

    #ifdef HAS_LIGHTMAP
        #ifdef SEPARATE_TEXCOORD
            color.rgb *= texture2D(m_LightMap, texCoord2).rgb;
        #else
            color.rgb *= texture2D(m_LightMap, texCoord1).rgb;
        #endif
    #endif

    gl_FragColor = color;

    #ifdef LOGARITHIMIC_DEPTH_BUFFER
       gl_FragDepth = computeLogDepthBuffer(positionProjectionSpace.z, g_FrustumNearFar.x, g_FrustumNearFar.y);
    #endif

}