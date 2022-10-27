package interview.matrix;

import java.text.DecimalFormat;
import java.text.NumberFormat;

public class Matrix4f implements Matrix {

    float m00, m01, m02, m03;
    float m10, m11, m12, m13;
    float m20, m21, m22, m23;
    float m30, m31, m32, m33;


    /**
     * Create a new {@link Matrix4f}.
     */
    public Matrix4f() {
                 m00(1.0f).m01(1.0f).m02(1.0f).m03(1.0f)
                .m10(1.0f).m11(1.0f).m12(1.0f).m13(1.0f)
                .m20(1.0f).m21(1.0f).m22(1.0f).m23(1.0f)
                .m30(1.0f).m31(1.0f).m32(1.0f).m33(1.0f);
    }


    /**
     * Set the value of the matrix element at column 0 and row 0.
     *
     * @param m00 the new value
     * @return this
     */
    public Matrix4f m00(float m00) {
        this.m00 = m00;
        return this;
    }

    /**
     * Set the value of the matrix element at column 0 and row 1.
     *
     * @param m01 the new value
     * @return this
     */
    public Matrix4f m01(float m01) {
        this.m01 = m01;
        return this;
    }

    /**
     * Set the value of the matrix element at column 0 and row 2.
     *
     * @param m02 the new value
     * @return this
     */
    public Matrix4f m02(float m02) {
        this.m02 = m02;
        return this;
    }

    /**
     * Set the value of the matrix element at column 0 and row 3.
     *
     * @param m03 the new value
     * @return this
     */
    public Matrix4f m03(float m03) {
        this.m03 = m03;
        return this;
    }

    /**
     * Set the value of the matrix element at column 1 and row 0.
     *
     * @param m10 the new value
     * @return this
     */
    public Matrix4f m10(float m10) {
        this.m10 = m10;
        return this;
    }

    /**
     * Set the value of the matrix element at column 1 and row 1.
     *
     * @param m11 the new value
     * @return this
     */
    public Matrix4f m11(float m11) {
        this.m11 = m11;
        return this;
    }

    /**
     * Set the value of the matrix element at column 1 and row 2.
     *
     * @param m12 the new value
     * @return this
     */
    public Matrix4f m12(float m12) {
        this.m12 = m12;
        return this;
    }

    /**
     * Set the value of the matrix element at column 1 and row 3.
     *
     * @param m13 the new value
     * @return this
     */
    public Matrix4f m13(float m13) {
        this.m13 = m13;
        return this;
    }

    /**
     * Set the value of the matrix element at column 2 and row 0.
     *
     * @param m20 the new value
     * @return this
     */
    public Matrix4f m20(float m20) {
        this.m20 = m20;
        return this;
    }

    /**
     * Set the value of the matrix element at column 2 and row 1.
     *
     * @param m21 the new value
     * @return this
     */
    public Matrix4f m21(float m21) {
        this.m21 = m21;
        return this;
    }

    /**
     * Set the value of the matrix element at column 2 and row 2.
     *
     * @param m22 the new value
     * @return this
     */
    public Matrix4f m22(float m22) {
        this.m22 = m22;
        return this;
    }

    /**
     * Set the value of the matrix element at column 2 and row 3.
     *
     * @param m23 the new value
     * @return this
     */
    public Matrix4f m23(float m23) {
        this.m23 = m23;
        return this;
    }

    /**
     * Set the value of the matrix element at column 3 and row 0.
     *
     * @param m30 the new value
     * @return this
     */
    public Matrix4f m30(float m30) {
        this.m30 = m30;
        return this;
    }

    /**
     * Set the value of the matrix element at column 3 and row 1.
     *
     * @param m31 the new value
     * @return this
     */
    public Matrix4f m31(float m31) {
        this.m31 = m31;
        return this;
    }

    /**
     * Set the value of the matrix element at column 3 and row 2.
     *
     * @param m32 the new value
     * @return this
     */
    public Matrix4f m32(float m32) {
        this.m32 = m32;
        return this;
    }

    /**
     * Set the value of the matrix element at column 3 and row 3.
     *
     * @param m33 the new value
     * @return this
     */
    public Matrix4f m33(float m33) {
        this.m33 = m33;
        return this;
    }

    @Override
    public float m00() {
        return m00;
    }

    @Override
    public float m01() {
        return m01;
    }

    @Override
    public float m02() {
        return m02;
    }

    @Override
    public float m03() {
        return m03;
    }

    @Override
    public float m10() {
        return m10;
    }

    @Override
    public float m11() {
        return m11;
    }

    @Override
    public float m12() {
        return m12;
    }

    @Override
    public float m13() {
        return m13;
    }

    @Override
    public float m20() {
        return m20;
    }

    @Override
    public float m21() {
        return m21;
    }

    @Override
    public float m22() {
        return m22;
    }

    @Override
    public float m23() {
        return m23;
    }

    @Override
    public float m30() {
        return m30;
    }

    @Override
    public float m31() {
        return m31;
    }

    @Override
    public float m32() {
        return m32;
    }

    @Override
    public float m33() {
        return m33;
    }

    @Override
    public Matrix mul(Matrix matrix) {
        return mul(
                matrix.m00(), matrix.m01(), matrix.m02(), matrix.m03(),
                matrix.m10(), matrix.m11(), matrix.m12(), matrix.m13(),
                matrix.m20(), matrix.m21(), matrix.m22(), matrix.m23(),
                matrix.m30(), matrix.m31(), matrix.m32(), matrix.m33());
    }

    @Override
    public Matrix4f mul(
            float r00, float r01, float r02, float r03,
            float r10, float r11, float r12, float r13,
            float r20, float r21, float r22, float r23,
            float r30, float r31, float r32, float r33) {
        float nm00 = Math.fma(m00, r00,
                Math.fma(m10, r01,
                Math.fma(m20, r02,
                        m30 * r03)
                ));
        float nm01 = Math.fma(m01, r00, Math.fma(m11, r01, Math.fma(m21, r02, m31 * r03)));
        float nm02 = Math.fma(m02, r00, Math.fma(m12, r01, Math.fma(m22, r02, m32 * r03)));
        float nm03 = Math.fma(m03, r00, Math.fma(m13, r01, Math.fma(m23, r02, m33 * r03)));
        float nm10 = Math.fma(m00, r10, Math.fma(m10, r11, Math.fma(m20, r12, m30 * r13)));
        float nm11 = Math.fma(m01, r10, Math.fma(m11, r11, Math.fma(m21, r12, m31 * r13)));
        float nm12 = Math.fma(m02, r10, Math.fma(m12, r11, Math.fma(m22, r12, m32 * r13)));
        float nm13 = Math.fma(m03, r10, Math.fma(m13, r11, Math.fma(m23, r12, m33 * r13)));
        float nm20 = Math.fma(m00, r20, Math.fma(m10, r21, Math.fma(m20, r22, m30 * r23)));
        float nm21 = Math.fma(m01, r20, Math.fma(m11, r21, Math.fma(m21, r22, m31 * r23)));
        float nm22 = Math.fma(m02, r20, Math.fma(m12, r21, Math.fma(m22, r22, m32 * r23)));
        float nm23 = Math.fma(m03, r20, Math.fma(m13, r21, Math.fma(m23, r22, m33 * r23)));
        float nm30 = Math.fma(m00, r30, Math.fma(m10, r31, Math.fma(m20, r32, m30 * r33)));
        float nm31 = Math.fma(m01, r30, Math.fma(m11, r31, Math.fma(m21, r32, m31 * r33)));
        float nm32 = Math.fma(m02, r30, Math.fma(m12, r31, Math.fma(m22, r32, m32 * r33)));
        float nm33 = Math.fma(m03, r30, Math.fma(m13, r31, Math.fma(m23, r32, m33 * r33)));
        return m00(nm00)
                .m01(nm01).m02(nm02).m03(nm03).m01(nm03)
                .m10(nm10).m11(nm11).m12(nm12).m13(nm13)
                .m20(nm20).m21(nm21).m22(nm22).m23(nm23)
                .m30(nm30).m31(nm31).m32(nm32).m33(nm33);
    }

    /**
     * Return a string representation of this matrix
     * @return the string representation
     */
    @Override
    public String toString() {
        return m00  + " " + m10 + " " + m20+ " " + m30 + "\n"
                + m01  + " " + m11 + " " + m21+ " " + m31 + "\n"
                + m02  + " " + m12 + " " + m22+ " " + m32 + "\n"
                + m03  + " " + m13 + " " + m23+ " " + m33 + "\n";
    }
}
