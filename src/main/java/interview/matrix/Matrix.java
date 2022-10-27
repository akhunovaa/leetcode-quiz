package interview.matrix;

public interface Matrix {


    /**
     * Return the value of the matrix element at column 0 and row 0.
     *
     * @return the value of the matrix element
     */
    float m00();

    /**
     * Return the value of the matrix element at column 0 and row 1.
     *
     * @return the value of the matrix element
     */
    float m01();

    /**
     * Return the value of the matrix element at column 0 and row 2.
     *
     * @return the value of the matrix element
     */
    float m02();

    /**
     * Return the value of the matrix element at column 0 and row 3.
     *
     * @return the value of the matrix element
     */
    float m03();

    /**
     * Return the value of the matrix element at column 1 and row 0.
     *
     * @return the value of the matrix element
     */
    float m10();

    /**
     * Return the value of the matrix element at column 1 and row 1.
     *
     * @return the value of the matrix element
     */
    float m11();

    /**
     * Return the value of the matrix element at column 1 and row 2.
     *
     * @return the value of the matrix element
     */
    float m12();

    /**
     * Return the value of the matrix element at column 1 and row 3.
     *
     * @return the value of the matrix element
     */
    float m13();

    /**
     * Return the value of the matrix element at column 2 and row 0.
     *
     * @return the value of the matrix element
     */
    float m20();

    /**
     * Return the value of the matrix element at column 2 and row 1.
     *
     * @return the value of the matrix element
     */
    float m21();

    /**
     * Return the value of the matrix element at column 2 and row 2.
     *
     * @return the value of the matrix element
     */
    float m22();

    /**
     * Return the value of the matrix element at column 2 and row 3.
     *
     * @return the value of the matrix element
     */
    float m23();

    /**
     * Return the value of the matrix element at column 3 and row 0.
     *
     * @return the value of the matrix element
     */
    float m30();

    /**
     * Return the value of the matrix element at column 3 and row 1.
     *
     * @return the value of the matrix element
     */
    float m31();

    /**
     * Return the value of the matrix element at column 3 and row 2.
     *
     * @return the value of the matrix element
     */
    float m32();

    /**
     * Return the value of the matrix element at column 3 and row 3.
     *
     * @return the value of the matrix element
     */
    float m33();


    /**
     * Multiply this matrix by the supplied <code>right</code> matrix and store the result in <code>dest</code>.
     * <p>
     * If <code>M</code> is <code>this</code> matrix and <code>R</code> the <code>right</code> matrix,
     * then the new matrix will be <code>M * R</code>. So when transforming a
     * vector <code>v</code> with the new matrix by using <code>M * R * v</code>, the
     * transformation of the right matrix will be applied first!
     *
     * @param matrix
     *          the matrix operand of the matrix multiplication
     * @return dest
     */
    Matrix mul(Matrix matrix);


    /**
     * Multiply this matrix by the matrix with the supplied elements and store the result in <code>dest</code>.
     * <p>
     * If <code>M</code> is <code>this</code> matrix and <code>R</code> the <code>right</code> matrix whose
     * elements are supplied via the parameters, then the new matrix will be <code>M * R</code>.
     * So when transforming a vector <code>v</code> with the new matrix by using <code>M * R * v</code>, the
     * transformation of the right matrix will be applied first!
     *
     * @param r00
     *          the m00 element of the right matrix
     * @param r01
     *          the m01 element of the right matrix
     * @param r02
     *          the m02 element of the right matrix
     * @param r03
     *          the m03 element of the right matrix
     * @param r10
     *          the m10 element of the right matrix
     * @param r11
     *          the m11 element of the right matrix
     * @param r12
     *          the m12 element of the right matrix
     * @param r13
     *          the m13 element of the right matrix
     * @param r20
     *          the m20 element of the right matrix
     * @param r21
     *          the m21 element of the right matrix
     * @param r22
     *          the m22 element of the right matrix
     * @param r23
     *          the m23 element of the right matrix
     * @param r30
     *          the m30 element of the right matrix
     * @param r31
     *          the m31 element of the right matrix
     * @param r32
     *          the m32 element of the right matrix
     * @param r33
     *          the m33 element of the right matrix
     * @return dest
     */
    Matrix4f mul(
            float r00, float r01, float r02, float r03,
            float r10, float r11, float r12, float r13,
            float r20, float r21, float r22, float r23,
            float r30, float r31, float r32, float r33);

}
