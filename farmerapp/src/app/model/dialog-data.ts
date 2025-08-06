export type DialogAction = 'CANCEL' | 'SAVE';

export interface DialogData {
    action: DialogAction,
    success?: boolean
}