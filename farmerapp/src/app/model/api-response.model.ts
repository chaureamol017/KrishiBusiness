export interface ApiResponse<D> {
    success: boolean,
    message: String,
    data: D,

}