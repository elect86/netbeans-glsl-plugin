/*
 * Copyright (C) 2013 João Vicente Reis
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package org.glsl.lexer;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author João Vicente Reis
 */
public class GlslKeywords {

    private static final String keywordsString1 = ""
            + "attribute "
            + "break "
            + "buffer "
            + "case "
            + "centroid "
            + "coherent "
            + "const "
            + "continue "
            + "default  "
            + "discard "
            + "do "
            + "else "
            + "false "
            + "flat "
            + "for "
            + "highp "
            + "if "
            + "in "
            + "inout "
            + "invariant "
            + "layout "
            + "lowp "
            + "mediump "
            + "noperspective "
            + "out "
            + "patch "
            + "precision"
            + "readonly "
            + "restrict "
            + "return "
            + "sample "
            + "shared "
            + "smooth "
            + "struct "
            + "subroutine "
            + "switch "
            + "true "
            + "uniform "
            + "varying "
            + "volatile "
            + "while "
            + "writeonly ";
    private static final String keywordsString2 = ""
            + "atomic_uint "
            + "bool "
            + "bvec2 "
            + "bvec3 "
            + "bvec4 "
            + "dmat2 "
            + "dmat2x2 "
            + "dmat2x3 "
            + "dmat2x4 "
            + "dmat3 "
            + "dmat3x2 "
            + "dmat3x3 "
            + "dmat3x4 "
            + "dmat4 "
            + "dmat4x2 "
            + "dmat4x3 "
            + "dmat4x4 "
            + "double "
            + "dvec2 "
            + "dvec3 "
            + "dvec4 "
            + "float "
            + "iimage1D "
            + "iimage1DArray "
            + "iimage2D "
            + "iimage2DArray "
            + "iimage2DMS "
            + "iimage2DMSArray "
            + "iimage2DRect "
            + "iimage3D "
            + "iimageBuffer "
            + "iimageCube "
            + "iimageCubeArray "
            + "image1D "
            + "image1DArray "
            + "image2D "
            + "image2DArray "
            + "image2DMS "
            + "image2DMSArray "
            + "image2DRect "
            + "image3D "
            + "imageBuffer "
            + "imageCube "
            + "imageCubeArray "
            + "int "
            + "isampler1D "
            + "isampler1DArray "
            + "isampler2D "
            + "isampler2DArray "
            + "isampler2DMS "
            + "isampler2DMSArray "
            + "isampler2DRect "
            + "isampler3D "
            + "isamplerBuffer "
            + "isamplerCube "
            + "isamplerCubeArray "
            + "ivec2 "
            + "ivec3 "
            + "ivec4 "
            + "mat2 "
            + "mat2x2 "
            + "mat2x3 "
            + "mat2x4 "
            + "mat3 "
            + "mat3x2 "
            + "mat3x3 "
            + "mat3x4 "
            + "mat4 "
            + "mat4x2 "
            + "mat4x3 "
            + "mat4x4 "
            + "sampler1D "
            + "sampler1DArray "
            + "sampler1DArrayShadow "
            + "sampler1DShadow "
            + "sampler2DArray "
            + "sampler2DArrayShadow "
            + "sampler2DMS "
            + "sampler2DMSArray "
            + "sampler2DRect "
            + "sampler2DRectShadow "
            + "sampler2DShadow "
            + "sampler2D "
            + "sampler3D "
            + "samplerBuffer "
            + "samplerCube "
            + "samplerCubeArray "
            + "samplerCubeArrayShadow "
            + "samplerCubeShadow "
            + "vec2 "
            + "vec3 "
            + "vec4 "
            + "void "
            + "uimage1D "
            + "uimage1DArray "
            + "uimage2D "
            + "uimage2DArray "
            + "uimage2DMS "
            + "uimage2DMSArray "
            + "uimage2DRect "
            + "uimage3D "
            + "uimageBuffer "
            + "uimageCube "
            + "uimageCubeArray "
            + "uint "
            + "usampler1D "
            + "usampler1DArray "
            + "usampler2D "
            + "usampler2DArray "
            + "usampler2DMS "
            + "usampler2DMSArray "
            + "usampler2DRect "
            + "usampler3D "
            + "usamplerBuffer "
            + "usamplerCube "
            + "usamplerCubeArray "
            + "uvec2 "
            + "uvec3 "
            + "uvec4";
    private static final String keywordsString3 = ""
            + "# "
            + "#define "
            + "#elif "
            + "#else "
            + "#endif "
            + "#error "
            + "#extension "
            + "#if "
            + "#ifdef "
            + "#ifndef "
            + "#include"
            + "#line "
            + "#pragma "
            + "#undef "
            + "#version ";
    private static final String keywordsString4 = ""
            + "gl_ClipDistance "
            + "gl_FragCoord "
            + "gl_FragDepth "
            + "gl_FrontFacing "
            + "gl_GlobalInvocationID "
            + "gl_in "
            + "gl_InstanceID "
            + "gl_InvocationID "
            + "gl_Layer "
            + "gl_LocalInvocationID "
            + "gl_LocalInvocationIndex "
            + "gl_NumWorkGroups "
            + "gl_out "
            + "gl_PatchVerticesIn "
            + "gl_PerVertex "
            + "gl_PointCoord "
            + "gl_PointSize "
            + "gl_Position "
            + "gl_PrimitiveID "
            + "gl_PrimitiveIDIn "
            + "gl_SampleID "
            + "gl_SampleMask"
            + "gl_SampleMaskIn "
            + "gl_SamplePosition "
            + "gl_TessCoord "
            + "gl_TessLevelInner "
            + "gl_TessLevelOuter "
            + "gl_VertexID "
            + "gl_ViewportIndex "
            + "gl_WorkGroupID "
            + "gl_WorkGroupSize ";
    private static final String keywordsString5 = ""
            + "gl_MaxClipDistances "
            + "gl_MaxCombinedImageUniforms "
            + "gl_MaxCombinedImageUnitsAndFragmentOutputs "
            + "gl_MaxCombinedTextureImageUnits "
            + "gl_MaxComputeAtomicCounterBuffers "
            + "gl_MaxComputeAtomicCounters "
            + "gl_MaxComputeImageUniforms "
            + "gl_MaxComputeTextureImageUnits "
            + "gl_MaxComputeUniformComponents "
            + "gl_MaxComputeWorkGroupCount "
            + "gl_MaxComputeWorkGroupSize "
            + "gl_MaxDrawBuffers "
            + "gl_MaxFragmentImageUniforms "
            + "gl_MaxFragmentInputComponents "
            + "gl_MaxFragmentUniformComponents "
            + "gl_MaxGeometryImageUniforms "
            + "gl_MaxGeometryInputComponents "
            + "gl_MaxGeometryOutputComponents "
            + "gl_MaxGeometryOutputVertices "
            + "gl_MaxGeometryTextureImageUnits "
            + "gl_MaxGeometryTotalOutputComponents "
            + "gl_MaxGeometryUniformComponents "
            + "gl_MaxImageSamples "
            + "gl_MaxImageUnits "
            + "gl_MaxTessControlImageUniforms "
            + "gl_MaxTessEvaluationImageUniforms "
            + "gl_MaxTextureImageUnits "
            + "gl_MaxVaryingComponents "
            + "gl_MaxVertexAttribs "
            + "gl_MaxVertexImageUniforms "
            + "gl_MaxVertexOutputComponents "
            + "gl_MaxVertexTextureImageUnits "
            + "gl_MaxVertexUniformComponents "
            + "gl_MaxGeometryVaryingComponents gl_MaxTessControlInputComponents "
            + "gl_MaxTessControlOutputComponents gl_MaxTessControlTextureImageUnits "
            + "gl_MaxTessControlUniformComponents gl_MaxTessControlTotalOutputComponents "
            + "gl_MaxTessEvaluationInputComponents gl_MaxTessEvaluationOutputComponents "
            + "gl_MaxTessEvaluationTextureImageUnits gl_MaxTessEvaluationUniformComponents "
            + "gl_MaxTessPatchComponents gl_MaxPatchVertices gl_MaxTessGenLevel gl_MaxViewports "
            + "gl_MaxVertexUniformVectors gl_MaxFragmentUniformVectors gl_MaxVaryingVectors "
            + "gl_MaxVertexAtomicCounters gl_MaxTessControlAtomicCounters "
            + "gl_MaxTessEvaluationAtomicCounters gl_MaxGeometryAtomicCounters "
            + "gl_MaxFragmentAtomicCounters gl_MaxCombinedAtomicCounters gl_MaxAtomicCounterBindings "
            + "gl_MaxVertexAtomicCounterBuffers gl_MaxTessControlAtomicCounterBuffers "
            + "gl_MaxTessEvaluationAtomicCounterBuffers gl_MaxGeometryAtomicCounterBuffers "
            + "gl_MaxFragmentAtomicCounterBuffers gl_MaxCombinedAtomicCounterBuffers "
            + "gl_MaxAtomicCounterBufferSize gl_MinProgramTexelOffset gl_MaxProgramTexelOffset";
    private static final String keywordsString6 = "radians degrees sin cos tan asin acos atan sinh cosh tanh asinh acosh atanh pow exp log exp2 log2 sqrt inversqrt abs sign floor trunc round roundEven ceil fract mod modf min max clamp mix step smoothstep isnan isinf floatBitsToInt floatBitsToUInt intBitsToFloat uintBitsToFloat fma frexp ldexp packUnorm2x16 packSnorm2x16 packUnorm4x8 packSnorm4x8 unpackUnorm2x16 unpackSnorm2x16 unpackUnorm4x8 unpackSnorm4x8  packDouble2x32 unpackDouble2x32 packHalf2x16 unpackHalf2x16 length distance dot cross normalize faceforward reflect refract matrixCompMult outerProduct transpose determinant inverse lessThan lessThanEqual greaterThan greaterThanEqual equal notEqual any all not uaddCarry usubBorrow umulExtended imulExtended bitfieldExtract bitfieldInsert bitfieldReverse findLSB bitCount findMSB textureSize textureQueryLod textureQueryLevels texture textureProj textureLod textureOffset texelFetch texelFetchOffset textureProjOffset textureLodOffset textureProjLod textureProjLodOffset textureGrad textureGradOffset textureProjGrad textureProjGradOffset textureGather textureGatherOffset textureGatherOffsets texture1D texture1DProj texture1DLod texture1DProjLod texture2D texture2DProj texture2DLod texture2DProjLod texture3D texture3DProj texture3DLod texture3DProjLod textureCube textureCubeLod shadow1D shadow2D shadow1DProj shadow2DProj shadow1DLod shadow2DLod shadow1DProjLod shadow2DProjLod atomicCounterIncrement atomicCounterDecrement atomicCounter atomicAdd atomicMin atomicMax atomicAnd atomicOr atomicXor atomicExchange atomicCompSwap imageSize imageLoad imageStore imageAtomicAdd imageAtomicMin imageAtomicMax imageAtomicAnd imageAtomicOr imageAtomicXor imageAtomicExchange imageAtomicCompSwap dFdx dFdy fwidth interpolateAtCentroid interpolateAtSample interpolateAtOffset noise1 noise2 noise3 noise4 EmitStreamVertex EndStreamPrimitive EmitVertex EndPrimitive barrier memoryBarriermemoryBarrierAtomicCounter memoryBarrierBuffer memoryBarrierShared memoryBarrierImage groupMemoryBarrier";

    static final Map<String, GlslTokenId> keywords1 = new HashMap<String, GlslTokenId>();
    static final Map<String, GlslTokenId> keywords2 = new HashMap<String, GlslTokenId>();
    static final Map<String, GlslTokenId> keywords3 = new HashMap<String, GlslTokenId>();
    static final Map<String, GlslTokenId> keywords4 = new HashMap<String, GlslTokenId>();
    static final Map<String, GlslTokenId> keywords5 = new HashMap<String, GlslTokenId>();
    static final Map<String, GlslTokenId> keywords6 = new HashMap<String, GlslTokenId>();

    static {
        Scanner scanner;

        scanner = new Scanner(keywordsString1);
        while (scanner.hasNext()) {
            keywords1.put(scanner.next(), GlslTokenId.KEYWORD);
        }
        scanner = new Scanner(keywordsString2);
        while (scanner.hasNext()) {
            keywords2.put(scanner.next(), GlslTokenId.BASIC_TYPE);
        }
        scanner = new Scanner(keywordsString3);
        while (scanner.hasNext()) {
            keywords3.put(scanner.next(), GlslTokenId.PREPROCESSOR);
        }
        scanner = new Scanner(keywordsString4);
        while (scanner.hasNext()) {
            keywords4.put(scanner.next(), GlslTokenId.BUILTIN_VAR);
        }
        scanner = new Scanner(keywordsString5);
        while (scanner.hasNext()) {
            keywords5.put(scanner.next(), GlslTokenId.BUILTIN_VAR);
        }
        scanner = new Scanner(keywordsString6);
        while (scanner.hasNext()) {
            keywords6.put(scanner.next(), GlslTokenId.BUILTIN_FUNC);
        }
    }
}
