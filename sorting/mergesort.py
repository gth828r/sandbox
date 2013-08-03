def _merge(left_list, right_list):
    merged_list = []
   
    l_index = 0
    r_index = 0

    if not left_list:
        return right_list

    if not right_list:
        return left_list

    for i in range(len(left_list) + len(right_list)):

        if left_list[l_index] <= right_list[r_index]:
             merged_list.append(left_list[l_index])
             l_index = l_index + 1
        else:
             merged_list.append(right_list[r_index])
             r_index = r_index + 1

    return merged_list

def mergesort(unsorted_list):
    if len(unsorted_list) <= 1:
        print unsorted_list
        return unsorted_list

    midpoint = (len(unsorted_list) - 1) // 2

    left_list = unsorted_list[0:midpoint]
    right_list = unsorted_list[midpoint+1:len(unsorted_list)-1]

    if left_list is None:
        left_list = []

    if right_list is None:
        right_list = []

    print left_list
    print right_list

    r_left_list = mergesort(left_list)
    r_right_list = mergesort(right_list)

    return_list = _merge(r_left_list, r_right_list)

    return return_list 
