
export class CommonUtil {
    public static parseToInt(value: string): number {

        let resp;
        if (value) {
            resp = parseInt(value);
            if (isNaN(resp)) {
                resp = -1;
            }
        } else {
            resp = -1;
        }
        return resp;
    }
}
